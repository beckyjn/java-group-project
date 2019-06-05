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

  return(
    <div className="customers-list">
      {customersNodes}
    </div>
  );

}

export default CustomerList;
