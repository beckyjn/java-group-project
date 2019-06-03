import React, { Component } from "react";
import Main from "./components/Main";
import RestaurantContainer from "./containers/RestaurantContainer";

class App extends Component {
  render() {
    return (
      <>
        <Main />
        <RestaurantContainer />
      </>
    );
  }
}

export default App;
