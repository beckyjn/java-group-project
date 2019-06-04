import React, { Component } from "react";

class RestaurantContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      bookings: null
    };
  }

  componentDidMount() {
    const url = "http://localhost:8080/bookings";
    fetch(url, {
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json"
      }
    })
      .then(res => res.json())
      .then(bookings => {
        this.setState({
          bookings: bookings._embedded.bookings
        });
      })
      .catch(error => {
        console.error(error);
      });
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
