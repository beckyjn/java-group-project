import React from 'react';
import RestaurantTableDetail from "./RestaurantTableDetail";

const BookingDetail = (props) => {
  // {console.log('this is a booking',props.booking)}
  if (props === undefined) {
    return(
      <p>Booking not found...</p>
    )
  }

  const tableNumbers = props.booking.restaurantTables
    .map(table => table.tableNumber);

  return (
    <div id="data-detail">
    <h1>Booking Details</h1>
    <h3>Customer Name: {props.booking.customer.name}</h3>
    <h3>Booking Date: {props.booking.date}</h3>
    <h3>Booking Time: {props.booking.time}</h3>
    <h3>Number in Party: {props.booking.numberInParty}</h3>
    <h3>Notes: {props.booking.notes}</h3>
    <h3>Tables Booked: {tableNumbers.join(', ')}</h3>
    </div>
    // get restaurant table details: embed them in bookings or make a button to view them
    // http://localhost:8080/bookings/1/restaurantTables
  );

}




export default BookingDetail;
