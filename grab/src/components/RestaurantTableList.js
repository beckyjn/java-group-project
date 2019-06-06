import React from "react";
import RestaurantTableDetail from "./RestaurantTableDetail"

const RestaurantTableList = props => {

  const restaurantTableList = props.restaurantTableData.map((entry, index) => {
    return(
      <>
      <RestaurantTableDetail
      key = {index}
      restaurantTable = {entry}
      >
      </RestaurantTableDetail>
      </>
    )
  });

  if( props.restaurantTableData === null ){
    return(
      <h3>Table availability loading...</h3>
    );
  }
  return(
    <>
    <h1>Tables Available</h1>
    <table  id="datalist">
    <tbody>
    <tr>
    <th>Table Number</th>
    <th>Seating</th>
    <th>ID</th>
    <th>See Bookings</th>

    </tr>
    {restaurantTableList}
      </tbody>
      </table>
    </>
  );
}




export default RestaurantTableList;
