import React, { Component } from "react";
import NavBar from "../components/Navbar";
import Home from "../components/Home";
import About from "../components/About";
import ErrorPage from "../components/ErrorPage";
import CustomerDetail from "../components/CustomerDetail";
import RestaurantTableDetail from "../components/RestaurantTableDetail";
import BookingDetail from "../components/BookingDetail";

import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

class RestaurantContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      bookings: null,
      customers: null,
      transactions: null,
      restaurantTables: null,
      selectedCustomer: {
"id": 3,
"name": "Maria",
"phone": "07293940234",
"email": "Maria@codeclan.com"
},
      selectedRestaurantTable: {
"id": 1,
"tableNumber": 1,
"seating": 4,
"_links": {
"self": {
"href": "http://localhost:8080/restaurantTables/1"
},
"restaurantTable": {
"href": "http://localhost:8080/restaurantTables/1"
},
"bookings": {
"href": "http://localhost:8080/restaurantTables/1/bookings{?projection}",
"templated": true
}
}
},
    selectedBooking: {
"id": 1,
"date": "10-06-2019",
"time": "17:00:00",
"numberInParty": 20,
"notes": "Graduation dinner",
"_embedded": {
"customer": {
"name": "Pim",
"phone": "07392383829",
"email": "Pim@codeclan.com",
"bookings": [
{
"id": 1,
"date": "10-06-2019",
"time": "17:00:00",
"numberInParty": 20,
"notes": "Graduation dinner"
}
],
"_links": {
"self": {
"href": "http://localhost:8080/customers/1{?projection}",
"templated": true
},
"bookings": {
"href": "http://localhost:8080/customers/1/bookings{?projection}",
"templated": true
},
"transactions": {
"href": "http://localhost:8080/customers/1/transactions"
}
}
}
},
"_links": {
"self": {
"href": "http://localhost:8080/bookings/1"
},
"booking": {
"href": "http://localhost:8080/bookings/1{?projection}",
"templated": true
},
"transactions": {
"href": "http://localhost:8080/bookings/1/transactions"
},
"customer": {
"href": "http://localhost:8080/bookings/1/customer{?projection}",
"templated": true
},
"restaurantTables": {
"href": "http://localhost:8080/bookings/1/restaurantTables"
}
}
}
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

  render() {
    return (
      <Router>
        <React.Fragment>
          <NavBar />
          <Switch>
            <Route exact path="/" component={Home} />
            <Route path="/about" component={About} />
            <Route component={ErrorPage} />
          </Switch>
        </React.Fragment>
        <CustomerDetail customer={this.state.selectedCustomer}/>
        <RestaurantTableDetail restaurantTable={this.state.selectedRestaurantTable}/>
        <BookingDetail booking={this.state.selectedBooking}/>

      </Router>
    );
  }
}

export default RestaurantContainer;
