import React from 'react';
import CustomerItem from './CustomerItem';
import CustomerDetail from './CustomerDetail';

const CustomerList = props =>  {
  function handleClick(evt) {
  const selectedCustomer = evt.target.value;
    console.log("selected booking", evt.target.value);
  props.onCustomerSelected(selectedCustomer);
  }

  const customersNodes = props.customers.map((customer, index) => {
    return (
      <tr value={customer.id} key={index}>
        <td>{customer.name}</td>
        <td>{customer.email}</td>
        <td>{customer.phone}</td>
        <button onClick={handleClick} value={customer.id}>More Details</button>
      </tr>

    );
  });

  if (props.customers === null) {
    return(
      <h3>Customers content loading...</h3>
    );
  }
  return(
    <div className="data-list-view">

    <table  id="datalist">
    <thead>
    <tr>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    </tr>
    </thead>
    <tbody>
    {customersNodes}
    </tbody>
    </table>
    </div>
  );
}


export default CustomerList;
