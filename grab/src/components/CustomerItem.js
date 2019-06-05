import React from 'react';

const CustomerItem = props => {
  return(
    <tr>
      <td>{ props.name }</td>
      <td>{ props.email }</td>
      <td>{ props.phone }</td>
    </tr>
  );
}

export default CustomerItem;
