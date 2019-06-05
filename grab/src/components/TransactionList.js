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

  return(
    <table>
    <tr>
    <th>Date</th>
    <th>Paid</th>
    <th>Due</th>
    <th>Balance</th>
    <th>Warning</th>
    </tr>
    {allTransactions}
    </table>
  );
}

export default TransactionList;
