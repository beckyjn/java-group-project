import React, { Component } from "react";
import NavBar from "../components/Navbar";
import Home from "../components/Home";
import About from "../components/About";
import ErrorPage from "../components/ErrorPage";
import BookingForm from '../components/BookingForm';
import CustomerDetail from "../components/CustomerDetail";
import RestaurantTableDetail from "../components/RestaurantTableDetail";
import BookingDetail from "../components/BookingDetail";
import TransactionDetail from "../components/TransactionDetail";
import TransactionList from "../components/TransactionList";
import BookingList from "../components/BookingList";
import CustomerList from "../components/CustomerList";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

class RestaurantContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      bookings: [],
      customers: [],
      transactions: [],
      restaurantTables: [],
      selectedBooking: null,
      selectedRestaurantTable: null,
      selectedCustomer: null,
      selectedTransaction: null
    };
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
    this.fetchData("http://localhost:8080/bookings", bookings => {
      this.setState({ bookings: bookings._embedded.bookings });
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
  }

  selectBooking(selectedIndex) {
    const selectedBooking = this.state.bookings[selectedIndex];
    console.log(selectedBooking);
    this.setState({ selectedBooking })
  }

  render() {
    return (
      <Router>
        <React.Fragment>
          <NavBar />
          <BookingForm customers={this.state.customers} restaurantTables={this.state.restaurantTables}/>
          <Switch>
            <Route exact path="/" component={Home} />
            <Route path="/about" component={About} />
            <Route
              exact
              path="/customers"
              render={() => <CustomerList customers={this.state.customers} />}
            />
            <Route
              exact
              path="/bookings"
              render={() => <>
                <BookingList
                  bookingsData={this.state.bookings}
                  onBookingSelected={this.selectBooking.bind(this)}
                  />
              <BookingDetail
              bookingDetail={this.state.selectedBooking}
              />
              </>
            }
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
