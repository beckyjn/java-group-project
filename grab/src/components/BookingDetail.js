import React from 'react';
import RestaurantTableDetail from "./RestaurantTableDetail";

const BookingDetail = (props) => {
  if (props.booking === undefined) {
    return(
      <p>Booking not found...</p>
    )
  }

  componentDidUpdate(prevProps) {
    
    if ( this.props.booking !== prevProps.booking ) {
      return (
        <div id="data-detail">
        {console.log(props.booking)}
        <h1>Booking Details:</h1>
        <h3>Customer Name:</h3>
        <p>{props.booking.date}</p>
        <h3>Booking Date:</h3>
        <h3>Booking Time:</h3>
        <h3>Number in Party:</h3>
        <h3>Tables Booked:</h3>
        </div>
        // get restaurant table details: embed them in bookings or make a button to view them
        // http://localhost:8080/bookings/1/restaurantTables
      );
    }
  }
}




export default BookingDetail;
