import React from 'react';
import RestaurantTableDetail from "./RestaurantTableDetail";

const CustomerDetail = (props) => {
  if (props === null) {
    return(
      <p>Customer not found...</p>
    )
  }

  const bookingsDetail = props.customer.bookings
    .map( (booking) => {
      return(
        <div>
        <tr>
        <td><strong>Booking Date:</strong></td>
        <td>{booking.date}</td>
        </tr>
        <tr>
        <td><strong>Booking Time:</strong></td>
        <td>{booking.time}</td>
        </tr>
        <tr>
        <td><strong>Guests:</strong></td>
        <td>{booking.numberInParty}</td>
        </tr>
        <tr>
        <td><strong>Notes:</strong></td>
        <td>{booking.notes}</td>
        </tr>
        </div>
      );
    })

  return (
    <div  id="data-detail">
    <h1>Customer Details</h1>
    <table className="data-table"><tbody>
    <tr>
    <td><h3>Name:</h3></td>
    <td>{props.customer.name}</td>
    </tr>
    <tr>
    <td><strong>ID:</strong></td>
    <td>{props.customer.id}</td>
    </tr>
    <tr>
    <td><strong>Phone:</strong></td>
    <td>{props.customer.phone}</td>
    </tr>
    <tr>
    <td><strong>Email:</strong></td>
    <td>{props.customer.email}</td>
    </tr>
    <tr>
    <td><strong>Bookings:</strong></td>
    <td>{bookingsDetail}</td>
    </tr>
    </tbody>
    </table>
    </div>

    // TODO: add customer number to url
    // Do we need more details embedded in the customer api? Bookings and transactions are gone
  )
}
export default CustomerDetail;
