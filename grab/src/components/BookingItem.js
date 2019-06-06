import React, {Component} from "react"

class BookingItem extends Component {
  constructor(props) {
    super(props);
    this.state = {
      bookings: []
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
  }

  findMatchingBooking() {
    const booking = this.state.bookings.find(({ id }) => id === props.match.params.bookingId);

    return(
      <div>
      <h2>Booking Details</h2>
      <h3>Customer Name: {booking.customer.name}</h3>
      <h3>Booking Date: {booking.date}</h3>
      <h3>Booking Time: {booking.time}</h3>
      <h3>Number in Party: {booking.numberInParty}</h3>
      <h3>Tables Booked: {bookings.restaurantTables.tableNumber}</h3>
      </div>
    );
  }

  render() {
    return(
      <div>
        {findMatchingBooking}
      </div>
    );
  }
}

export default BookingItem;
