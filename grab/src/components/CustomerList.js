import React from 'react';
import { Link } from 'react-router-dom';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import CustomerItem from './CustomerItem';

const CustomerList = (props) =>  {

  const customersNodes = props.customers.map((customer, index) => {
    return (
      <CustomerItem
      key = {index}
      name={ customer.name }
      email={ customer.email }
      phone={ customer.phone }></CustomerItem>
    );
  });

  return (
    <div className="customers-list">
      <h1>Customers</h1>
      {customersNodes}
    </div>
  );
}

export default CustomerList;
