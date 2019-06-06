import React, { Component } from "react";
import NavBar from "../components/Navbar";
import Home from "../components/Home";
import About from "../components/About";
import ErrorPage from "../components/ErrorPage";
import BookingForm from '../components/BookingForm';
import CustomerDetail from "../components/CustomerDetail";
import RestaurantTableDetail from "../components/RestaurantTableDetail";
import RestaurantTableList from "../components/RestaurantTableList";
import BookingDetail from "../components/BookingDetail";
import TransactionDetail from "../components/TransactionDetail";
import TransactionList from "../components/TransactionList";
import BookingList from "../components/BookingList";
import CustomerList from "../components/CustomerList";
import CustomerForm from "../components/CustomerForm";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

class RestaurantContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      todayBookings: [],
      bookings: [],
      customers: [],
      transactions: [],
      restaurantTables: [],
      restaurantTablesOnDate: [],
      dateChosen: null,
      selectedCustomer: null,
      selectedBooking: null,
      selectedTransaction: null
    };

    this.onBookingSubmit =  this.onBookingSubmit.bind(this);
    this.onCustomerSubmit = this.onCustomerSubmit.bind(this);
  }

  fetchData(url, callback) {
    fetch(url, {
      mode: "cors",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
        "Access-Control-Allow-Origin": "http://localhost:3000"
      }
    })
      .then(res => res.json())
      .then(callback)
      .catch(error => {
        console.error(error);
      });
  }

  componentDidMount() {
    const today = new Date()
    const year = today.getFullYear()
    const month = `${today.getMonth() + 1}`.padStart(2, 0)
    const day = `${today.getDate()}`.padStart(2, 0)
    const stringDate = [year, month, day].join("-")
    // console.log(stringDate);
    // console.log(`http://localhost:8080/bookings/date/${stringDate}`);

    this.fetchData(`http://localhost:8080/bookings/date/${stringDate}`, bookings => {
      this.setState({ todayBookings: bookings });
    });

    this.fetchData("http://localhost:8080/bookings", bookings => {
      let newBookings = bookings._embedded.bookings;
      this.setState({ bookings: newBookings });
    });
    this.fetchData("http://localhost:8080/customers", customers => {
      this.setState({ customers: customers._embedded.customers });
    });
    this.fetchData("http://localhost:8080/transactions", transactions => {
      this.setState({ transactions: transactions._embedded.transactions });
    });
    this.fetchData(
      "http://localhost:8080/restaurant-tables",
      restaurantTables => {
        this.setState({ restaurantTables: restaurantTables });
      }
    );
    this.fetchData(
      `http://localhost:8080/restaurantTables/availableondate/${stringDate}`,
      restaurantTables => {
        this.setState({ restaurantTablesOnDate: restaurantTables });
        this.setState({ dateChosen: stringDate})
        console.log('date chosen', stringDate);
      }
    );
  }

  onBookingSubmit(payload){
    fetch('http://localhost:8080/bookings', {
      mode: "cors",
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
        "Access-Control-Allow-Origin": "http://localhost:3000"
      },
      body: JSON.stringify(payload)
  })
  .then(res => res.json())
  .then(res => {   let bookings = [...this.state.bookings];
    bookings.push(res);
    this.setState({ bookings });
  })
  .catch(error => {
      console.error(error);
  });
  }

  onCustomerSubmit(payload){
      fetch('http://localhost:8080/customers', {
        mode: "cors",
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
          "Access-Control-Allow-Origin": "http://localhost:3000"
        },
        body: JSON.stringify(payload)
      })
      .then(res => res.json())
      .then(res => {
        let customers = [...this.state.customers];
        customers.push(res);
        this.setState({ customers });
      })
      .catch(error => {
          console.error(error);
      });
  }

  render() {
    return (
      <Router>
        <React.Fragment>
          <NavBar />
          <CustomerForm
            onSubmit={this.onCustomerSubmit}
            />
          <BookingForm
            onSubmit={this.onBookingSubmit}
            customers={this.state.customers}
            restaurantTables={this.state.restaurantTables}/>
          <Switch>
            <Route exact path="/" render={() => <BookingList bookingsData={this.state.todayBookings} />} />
            <Route path="/about" component={About} />
            <Route
              exact
              path="/customers"
              render={() => <CustomerList customers={this.state.customers} />}
            />
            <Route
              exact
              path="/bookings"
              render={() => <BookingList bookingsData={this.state.bookings} />}
            />
            <Route
              exact
              path="/tables"
              render={() => <RestaurantTableList restaurantTableData={this.state.restaurantTables} />}
            />
            <Route
              path="/tablesondate"
              render={() => <RestaurantTableList restaurantTableData={this.state.restaurantTablesOnDate} /> }
            />
            <Route
              exact
              path="/transactions"
              render={() => (
                <TransactionList transactionsData={this.state.transactions} />
              )}
            />
            <Route component={ErrorPage} />
          </Switch>
        </React.Fragment>

      </Router>
    );
  }
}

export default RestaurantContainer;
