import React from "react"

const BookingItem = props => {
  return(
    <div>
    <ul id="datalist">
      <li>{props.date}</li>
      <li>{props.name}</li>
      <li>{props.time}</li>
      <li>{props.partyNo}</li>
    </ul>
    </div>
  )
}

export default BookingItem;
