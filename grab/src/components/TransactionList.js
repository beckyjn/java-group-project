import React from "react";
import TransactionItem from "./TransactionItem";

const TransactionList = props => {
  const allTransactions = props.transactionsData.map((transaction, index) => {
    return (
      <TransactionItem
        key={index}
        date={transaction.date}
        amountPaid={transaction.amountPaid}
        amountOwing={transaction.amountOwing}
        balance={transaction.balance}
        warnings={transaction.warning}
      />
    );
  });

  if( props.transactionsData === null ){
    return(
      <h3>Transaction content loading...</h3>
    );
  }
  return(
    <table  id="datalist">
    <thead>
    <tr>
    <th>Date</th>
    <th>Paid</th>
    <th>Due</th>
    <th>Balance</th>
    <th>Warning</th>
    </tr>
    </thead>
    <tbody>
    {allTransactions}
    </tbody>
    </table>
  );
}

export default TransactionList;
