import React from 'react';

const RestaurantTableDetail = ({restaurantTable}) => {
  if (restaurantTable === null) {
      return(
          <p>Table not found...</p>
      )
  } else {
    let buttonUrl =String('http://localhost:3000/bookingsbytable/' + restaurantTable.id);
     console.log('buttonurl:', buttonUrl); // works here
  }
  return (
      <div  id="data-detail">
          <h1>Table Details:</h1>
          <h2>In a Table:</h2>
          <table className="data-table"><tbody><tr>
          <td><h3>Table Number:</h3></td>
          <td>{restaurantTable.tableNumber}</td>
          </tr><tr>
          <td><strong>Number of Seats:</strong></td>
          <td>{restaurantTable.seating}</td>
          </tr></tbody></table>
<div className="table-detail">
<h2>In Paragraphs:</h2>
<h3>Table Number:</h3>
<p>{restaurantTable.tableNumber}</p>
<h3>ID:</h3>
<p>{restaurantTable.id}</p>
<h3>Number of Seats:</h3>
<p>{restaurantTable.seating}</p>
</div>

      <a className="view-more-button" href='{this.buttonUrl}'>
        See Bookings for this Table
        </a>

        </div>
// TODO: pass the working buttonUrl into a href
  )
}
export default RestaurantTableDetail;
