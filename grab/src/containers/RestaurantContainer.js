import React, { Component } from "react";

class RestaurantContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      bookings: null,
      customers: null,
      transactions: null,
      restaurantTables: null
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
      <div>
        <h1>Restaurant Container</h1>
      </div>
    );
  }
}

export default RestaurantContainer;
