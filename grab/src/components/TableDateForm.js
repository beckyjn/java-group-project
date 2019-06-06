import React, {Component} from 'react';

class TableDateForm extends Component{

    constructor(props){
        super(props);

        this.state = {
            date: ''
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


        handleInputChange (event) {
            const stateName = event.target.name;
            const value = event.target.value;
            this.setState({
                [stateName]: value
            });
        }


            handleSubmit(event) {
                event.preventDefault();

                this.props.onSubmit(this.state.date)

                this.setState({
                    date: ''
            })
            console.log('date chosen:', this.state.date);
        }

        render () {

          return (
          <div className="booking-form">
            <h2>Check Tables by Date:</h2>
            <form id = "booking-form" onSubmit = {this.handleSubmit} action="http://localhost:3000/tablesondate">
                  <label htmlFor="date">Date: </label>
                  <input type="date" id="date" name="date" value={this.state.date} onChange={this.handleInputChange} required />

                  <br className = "clear" /><br />
                  <input type="submit" />
            </form>
          </div>
        )
      }
}

export default TableDateForm;
