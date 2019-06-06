import React, { Component } from "react";
import NavBar from "../components/Navbar";
import Home from "../components/Home";
import About from "../components/About";
import ErrorPage from "../components/ErrorPage";
import BookingForm from '../components/BookingForm';
import CustomerDetail from "../components/CustomerDetail";
import RestaurantTableDetail from "../components/RestaurantTableDetail";
import RestaurantTableList from "../components/RestaurantTableList";
import TableDateForm from '../components/TableDateForm';
import BookingDetail from "../components/BookingDetail";
import TransactionDetail from "../components/TransactionDetail";
import TransactionList from "../components/TransactionList";
import BookingList from "../components/BookingList";
import BookingItem from '../components/BookingItem';
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
      selectedBooking: {
        customer: {},
        restaurantTables: []
      },
      selectedRestaurantTable: null,
      selectedCustomer: {
        bookings: [{}]
      },
      selectedTransaction: null
    };

    this.onBookingSubmit =  this.onBookingSubmit.bind(this);
    this.onCustomerSubmit = this.onCustomerSubmit.bind(this);
    this.onTableDateSubmit = this.onTableDateSubmit.bind(this);

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
      `http://localhost:8080/restaurant-tables/availableondate/${stringDate}`,
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

  onTableDateSubmit(stringDate){
    this.fetchData(
      `http://localhost:8080/restaurant-tables/availableondate/${stringDate}`,
      restaurantTables => {
        this.setState({ restaurantTablesOnDate: restaurantTables });
        this.setState({ dateChosen: stringDate})
        // TODO: move user to /tablesondate/${date}
        console.log('date chosen', stringDate);
      }
    );
  }

  selectBooking(selectedIndex) {
    const selectedBooking = this.state.bookings[selectedIndex];
    console.log(selectedBooking);
    this.setState({ selectedBooking })
  }

  selectCustomer(selectedIndex) {
    const selectedCustomer = this.state.customers[selectedIndex];
    this.setState({ selectedCustomer })
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
              render={() =>
                <>
                <CustomerList customers={this.state.customers}
              onCustomerSelected={this.selectCustomer.bind(this)}/>
              <CustomerDetail customer={this.state.selectedCustomer}/>
              </>}
            />
            <Route
              exact
              path="/bookings"
              render={() =>
                <>
                <BookingList
                  bookingsData={this.state.bookings}
                  onBookingSelected={this.selectBooking.bind(this)}
                />
                <BookingDetail
                  booking={this.state.selectedBooking}
                />
              </>}
            />
          
            <Route
              path="/tablesondate"
              render={() => <RestaurantTableList  onSubmit={this.onTableDateSubmit} restaurantTableData={this.state.restaurantTablesOnDate} /> }
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
