import React from "react";
import BookingItem from "./BookingItem"

const BookingList = props => {

const bookingsList = props.bookings((entry, index) => {
  return(
  <BookingItem
    indexNumber = {index}
    date = {entry.date}
  </BookingItem>)
});

return(
  <div>
  {bookingList}

  </div>
);
}




export default BookingList;
