import React from 'react';

const TransactionDetail = ({transaction}) => {
  if (transaction === null) {
      return(
          <p>Transaction not found...</p>
      )
  }
  return (
  <div id="data-detail">
    <h1>Transaction Details:</h1>
    <h3>Transaction ID:</h3>
    <p>{transaction.id}</p>
    <h3>Transaction Date:</h3>
    <p>{transaction.date}</p>
    <h3>Customer Name:</h3>
    <p>{transaction._embedded.customer.name}</p>
    <h3>Booking Date:</h3>
    <p>{transaction._embedded.booking.date}</p>
    <h3>Amount Owing:</h3>
    <p>{transaction.amountOwing}</p>
    <h3>Amount Paid:</h3>
    <p>{transaction.amountPaid}</p>
    <h3>Balance:</h3>
    <p>{transaction.balance}</p>
    <h3>Notes:</h3>
    <p>{transaction.warnings}</p>
  </div>
// customer id not there - needs to be added to the embedding if needed
);
}

export default TransactionDetail;
