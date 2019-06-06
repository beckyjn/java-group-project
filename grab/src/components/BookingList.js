import React from "react";
import BookingItem from "./BookingItem"

const BookingList = props => {

  const bookingsList = props.bookingsData.map((entry, index) => {
    // console.log(entry);
    let definitelyAName = (entry._embedded)? entry._embedded.customer.name : entry.customer.name
    //TODO: hack: cleaning the date from server, which sometimes nests customer in _embedded
    return(
      <BookingItem
      key = {index}
      time = {entry.time}
      name = {definitelyAName}
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
    <thead>
    <tr>
    <th>Date</th>
    <th>Name</th>
    <th>Time</th>
    <th>Cover</th>
    </tr>
    </thead>
    <tbody>
    {bookingsList}
    </tbody>
    </table>
    </div>
  );
}




export default BookingList;
