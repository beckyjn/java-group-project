import React, { Component } from 'react';

class Song extends Component {
  render () {
    return(
      <div>
        <h3>{ this.props.name }</h3>
        <h3>{ this.props.email }</h3>
        <h3>{ this.props.phone }</h3>
      </div>
    );
  }
}
