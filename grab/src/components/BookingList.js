import React from "react";
import BookingItem from "./BookingItem"

const BookingList = props => {

  console.log(props);


const bookingsList = props.bookingsData.map((entry, index) => {
  return(
  <BookingItem
    key = {index}
    date = {entry.date}
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
