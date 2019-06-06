import React, {Component} from 'react';

class TableDateForm extends Component{

    constructor(props){
        super(props);

        this.state = {
            dateChosen: ''
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

                const payload = {
                    "dateChosen": this.state.dateChosen,
                };

                this.props.onSubmit(payload)

                this.setState({
                    dateChosen: ''
            })
        }

        render () {

          return (
          <div className="booking-form">
            <h2>Check Tables by Date:</h2>
            <form id = "booking-form" onSubmit = {this.handleSubmit}>
                  <label htmlFor="date">Date: </label>
                  <input type="date" id="date" name="date" value={this.state.dateChosen} onChange={this.handleInputChange} required />

                  <br className = "clear" /><br />
                  <input type="submit" />
            </form>
          </div>
        )
      }
}

export default TableDateForm;
