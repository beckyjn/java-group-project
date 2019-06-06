import React from 'react';
import RestaurantTableDetail from "./RestaurantTableDetail";

const CustomerDetail = ({customer}) => {
  if (customer === null) {
    return(
      <p>Customer not found...</p>
    )
  }
  return (
    <div  id="data-detail">
    <h1>Customer Details</h1>
    <table className="data-table"><tbody>
    <tr>
    <td><h3>Name:</h3></td>
    <td>{customer.name}</td>
    </tr>
    <tr>
    <td><strong>ID:</strong></td>
    <td>{customer.id}</td>
    </tr>
    <tr>
    <td><strong>Phone:</strong></td>
    <td>{customer.phone}</td>
    </tr>
    <tr>
    <td><strong>Email:</strong></td>
    <td>{customer.email}</td>
    </tr>
    </tbody>
    </table>
    </div>

    // TODO: add customer number to url
    // Do we need more details embedded in the customer api? Bookings and transactions are gone
  )
}
export default CustomerDetail;
