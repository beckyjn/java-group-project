import React, { Component } from "react";

class RestaurantContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      bookings: null
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/", {
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json"
      }
    })
      .then(response => {
        return response.json();
      })
      .then(bookings =>
        this.setState({
          bookings: bookings
        })
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
