import React from "react"

const BookingItem = props => {
  return(
    <tr>
    <td>{props.date}</td>
    <td>{props.name}</td>
    <td>{props.time}</td>
    <td>{props.partyNo}</td>
    </tr>
  )
}

export default BookingItem;
