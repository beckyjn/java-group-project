import React from "react";

const BookingItem = props => {
  return (
    <>
      <tr>
        <td>{props.date}</td>
        <td>{props.name}</td>
        <td>{props.time}</td>
        <td>{props.partyNo}</td>
      </tr>
      <button>
        <a href={`http://localhost:3000/bookings/${props.id}`}>More Details</a>
      </button>
    </>
  );
};

export default BookingItem;
