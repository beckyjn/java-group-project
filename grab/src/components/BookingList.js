import React from "react";
import BookingItem from "./BookingItem"

const BookingList = props => {

  function handleClick(evt) {
    // console.log(evt.target.value);
    const selectedBooking = evt.target.value;
    console.log("selected booking", selectedBooking);
    props.onBookingSelected(selectedBooking);
  }

  const bookingsList = props.bookingsData.map((booking, index) => {
    return(
      <tr value={booking.id} key={index}>
        <td>{booking.date}
        </td>
        <td>{booking.customer.name}
        </td>
        <td>{booking.time}
        </td>
        <td>{booking.numberInParty}
        </td>
        <button className="more-detail" onClick={handleClick}>More Details</button>
      </tr>
    )
  });

  if( props.bookingsData === null ){
    return(
      <h3>Bookings content loading...</h3>
    );
  }
  return(
    <table>
    <tr>
    <th>Date</th>
    <th>Name</th>
    <th>Time</th>
    <th>Cover</th>
    </tr>
    {bookingsList}
    </table>
  );
}




export default BookingList;
