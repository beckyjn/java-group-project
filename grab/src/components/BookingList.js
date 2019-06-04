import React from "react";
import BookingItem from "./BookingItem"

const BookingList = props => {

const bookingsList = props.bookings((entry, index) => {
  return(
  <BookingItem

  </BookingItem>)
});

return(
  <div>
  {bookingList}

  </div>
);
}




export default BookingList;
