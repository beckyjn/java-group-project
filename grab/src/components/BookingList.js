import React from "react";
import BookingItem from "./BookingItem"

const BookingList = props => {

  const bookingsList = props.bookingsData.map((entry, index) => {
    return(
      <BookingItem
      key = {index}
      time = {entry.time}
      name = {entry.customer.name}
      date = {entry.date}
      partyNo = {entry.numberInParty}
      >
      </BookingItem>
    )
  });

  if( props.bookingsData === null ){
    return(
      <h3>Bookings content loading...</h3>
    );
  }
  return(
    <div className="data-list-view">
    <table id="datalist">
    <tr>
    <th>Date</th>
    <th>Name</th>
    <th>Time</th>
    <th>Cover</th>
    </tr>
    {bookingsList}
    </table>
    </div>
  );
}




export default BookingList;
