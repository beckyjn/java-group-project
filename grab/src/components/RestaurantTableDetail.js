import React from 'react';

const RestaurantTableDetail = ({restaurantTable}) => {
  let buttonUrl = "";
  if (restaurantTable === null) {
      return(
          <p>Table not found...</p>
      )
  } else {
    let buttonUrl =String('http://localhost:3000/bookingsbytable/' + restaurantTable.id);
  }
  return (
    <tr>
            <td>{restaurantTable.tableNumber}</td>
            <td>{restaurantTable.seating}</td>
            <td>{restaurantTable.id}</td>
            <td>  <a className="view-more-button" href={buttonUrl}>
                See Bookings for this Table                </a>

                </td>
        </tr>
  )
}
export default RestaurantTableDetail;
