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
  </BookingItem>)
});

return(
  <div>
  {bookingsList}

  </div>
);
}




export default BookingList;
