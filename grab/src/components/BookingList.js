import React from "react";
import BookingDetail from "./BookingDetail";
import BookingItem from "./BookingItem";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

const BookingList = props => {
  function handleClick(evt) {
    // console.log(evt.target.value);
    const selectedBooking = evt.target.value;
    console.log("selected booking", evt.target.value);
    props.onBookingSelected(selectedBooking);
  }

  const bookingsList = props.bookingsData.map((booking, index) => {
    let definitelyAName = booking._embedded
      ? booking._embedded.customer.name
      : booking.customer.name;

    return (
      <>
        <tr value={booking.id} key={index}>
          <td>{booking.date}</td>
          <td>{definitelyAName}</td>
          <td>{booking.time}</td>
          <td>{booking.numberInParty}</td>
          <button onClick={handleClick} value={booking.id}>
            More Details
          </button>
        </tr>
      </>
    );
  });

  // const bookingsList = props.bookingsData.map( (booking, index) => {
  //   return(
  //     <>
  //       <tr key={index}>
  //         <Link to={`/bookings/${booking.id}`}>
  //           <td>{booking.date}</td>
  //           <td>{booking.customer.name}</td>
  //           <td>{booking.time}</td>
  //           <td>{booking.numberInParty}</td>
  //         </Link>
  //       </tr>
  //
  //       <Route
  //         path={`/bookings/:bookingId`}
  //         render ={ (match) => <BookingItem/>}
  //       />
  //     </>
  //   );
  // });

  if (props.bookingsData === null) {
    return <h3>Bookings content loading...</h3>;
  }
  return (
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
        <tbody>{bookingsList}</tbody>
      </table>
    </div>
  );
};

export default BookingList;
