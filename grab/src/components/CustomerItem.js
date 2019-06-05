import React from 'react';

const CustomerItem = props => {
  return(
    <div>
      <ul id="datalist">
        <li>{ props.name }</li>
        <li>{ props.email }</li>
        <li>{ props.phone }</li>
      </ul>
    </div>
  );
}

export default CustomerItem;
