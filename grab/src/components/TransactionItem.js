import React from "react";

const TransactionItem = props => {
  return (
    <tr>
      <td>{props.date}</td>
      <td>{props.amountPaid}</td>
      <td>{props.amountOwing}</td>
      <td>{props.balance}</td>
      <td>{props.warning}</td>
    </tr>
  );
};

export default TransactionItem;
