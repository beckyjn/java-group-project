import React from 'react';
import CustomerItem from './CustomerItem';

const CustomerList = props =>  {

  const customersNodes = props.customers.map((customer, index) => {
    return (
      <CustomerItem
      key = {index}
      name={ customer.name }
      email={ customer.email }
      phone={ customer.phone }></CustomerItem>
    );
  });

  if (props.customers === null) {
    return(
      <h3>Customers content loading...</h3>
    );
  }
  return(
    <table  id="datalist">
    <tr>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    </tr>
    {customersNodes}
    </table>
  );
}


export default CustomerList;
