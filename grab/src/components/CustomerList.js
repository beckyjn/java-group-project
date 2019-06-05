import React from 'react';
import { Link } from 'react-router-dom';
import { BrowserRouter as Router, Route, Switch, Match } from "react-router-dom";
import CustomerItem from './CustomerItem';
import CustomerDetail from './CustomerDetail'

const CustomerList = (props) =>  {
  console.log(props.match);

  const customersNodes = props.customers.map((customer, index) => {
    return (
      <li key={index}>
        <Link to={`${props.match.url}/${index+1}`}>
          {customer.name}
        </Link>
      </li>
    );
  });

  return (
    <div className="customers-list">
      <h1>Customers</h1>
      <ul>
      {customersNodes}
      </ul>
      <Route path={`${props.match.url}/:id`} component={CustomerItem}
        render={()=> <CustomerItem customer={props.customer}/> }/>
    </div>
  );
}

export default CustomerList;
