import React from "react";

const TransactionItem = props => {
  return (
    <div>
      <ul id="datalist">
        <li>{props.date}</li>
        <li>{props.amountPaid}</li>
        <li>{props.amountOwing}</li>
        <li>{props.balance}</li>
        <li>{props.warning}</li>
      </ul>
    </div>
  );
};

export default TransactionItem;
