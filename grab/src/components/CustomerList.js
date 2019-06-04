import React, { Component } from 'react';
import CustomerItem from './Customer';

class CustomerList extends Component {
  render() {
    const customersNodes = this.props.songs.map((customer) => {
      return (
        <CustomerItem
          name={ customer.name }
          email={ customer.email }
          phone={ customer.phone }
        />
      );
    })

    return(
      <div className="customers-list">
        { customersNodes }
      </div>
    );
  }
}
