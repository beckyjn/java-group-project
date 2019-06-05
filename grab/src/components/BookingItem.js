import React from "react"

const BookingItem = props => {

  return(
    // props.onBookingSelected(selectedBooking)
    <tr>
    <td>{props.date}</td>
    <td>{props.name}</td>
    <td>{props.time}</td>
    <td>{props.partyNo}</td>
    </tr>
  )
}

export default BookingItem;
