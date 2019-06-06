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
    .map((table) => table.tableNumber);

  return (
    <div id="data-detail">
    <h1>Booking Details</h1>
    <table className="data-table">
    <tbody>
    <tr>
    <td><h3>Name:</h3></td>
    <td>{props.booking.customer.name}</td>
    </tr>
    <tr>
    <td><strong>ID:</strong></td>
    <td>{props.booking.id}</td>
    </tr>
    <tr>
    <td><strong>Date</strong></td>
    <td>{props.booking.date}</td>
    </tr>
    <tr>
    <td><strong>Time:</strong></td>
    <td>{props.booking.time}</td>
    </tr>
    <tr>
    <td><strong>Nº in Party</strong></td>
    <td>{props.booking.numberInParty}</td>
    </tr>
    <tr>
    <td><strong>Notes:</strong></td>
    <td>{props.booking.notes}</td>
    </tr>
    <tr>
    <td><strong>Tables Booked</strong></td>
    <td>{tableNumbers.join(', ')}</td>
    </tr>
    </tbody>
    </table>
    </div>
    // get restaurant table details: embed them in bookings or make a button to view them
    // http://localhost:8080/bookings/1/restaurantTables
  );

}




export default BookingDetail;
