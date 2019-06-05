import React from 'react';

const CustomerItem = (props, {match}) => {
  return(
    <div>
      <ul>
        <li>{props.name}</li>
        <li>{props.email}</li>
        <li>{props.phone}</li>
      </ul>
    </div>
  );
}

export default CustomerItem;
