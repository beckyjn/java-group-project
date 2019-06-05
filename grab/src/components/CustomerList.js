import React, { Component } from 'react';
import CustomerItem from './CustomerItem';

class CustomerList extends Component {
  render() {
    const customersNodes = this.props.customers.map((customer) => {
      return (
        <CustomerItem
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
}

export default CustomerList;
