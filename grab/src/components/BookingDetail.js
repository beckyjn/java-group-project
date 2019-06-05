import React from 'react';
import RestaurantTableDetail from "./RestaurantTableDetail";

const BookingDetail = ({booking}) => {
  if (booking === null) {
      return(
          <p>Booking not found...</p>
      )
  }
  return (
  <div id="data-detail">
    <h1>Booking Details:</h1>
    <h3>Customer Name:</h3>
    <p>{booking._embedded.customer.name}</p>
    <h3>Booking Date:</h3>
    <p>{booking.date}</p>
    <h3>Booking Time:</h3>
    <p>{booking.time}</p>
    <h3>Number in Party:</h3>
    <p>{booking.numberInParty}</p>
    <h3>Tables Booked:</h3>
  </div>
  // get restaurant table details: embed them in bookings or make a button to view them
  // http://localhost:8080/bookings/1/restaurantTables
);
}




export default BookingDetail;
