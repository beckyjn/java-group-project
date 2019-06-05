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

  return <div className="transactions-list">{allTransactions}</div>;
};

export default TransactionList;
