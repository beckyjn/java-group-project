import React from 'react';
import RestaurantTableDetail from "./RestaurantTableDetail";

const CustomerItem = props => {
  if (props === undefined) {
    return(
      <p>Booking not found...</p>
    )
  }
  
  return(
    <tr>
      <td>{ props.name }</td>
      <td>{ props.email }</td>
      <td>{ props.phone }</td>
    </tr>
  );
}

export default CustomerItem;
