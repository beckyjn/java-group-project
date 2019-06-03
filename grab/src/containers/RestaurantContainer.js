import React, { Component } from "react";

class RestaurantContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      bookings: null
    };
  }

  componentDidMount() {
    const url = "/bookings";

    fetch(url).then(res => {
      res.json().then(bookings => {
        this.setState({ bookings: bookings });
      });
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
