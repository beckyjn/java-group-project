import React, {Component} from 'react';

class BookingForm extends Component{

    constructor(props){
        super(props);
        this.state = {
            customerId: '',
            numberOfGuests: '',
            tables: [],
            time: '',
            date: ''
        }

        this.handleDateChange = this.handleDateChange.bind(this);
        this.handleTimeChange = this.handleTimeChange.bind(this);
        this.handleGuestChange = this.handleGuestChange.bind(this);
    }

    handleDateChange (event) {
        this.setState({
            date: event.target.value
        });
    }

    handleTimeChange (event){
        this.setState({
            time: event.target.value
        })
    }

    handleGuestChange (event){
        this.setState({
            numberOfGuests: event.target.value
        })
    }

    render () {
        return (
            <div class="booking-form">
                <h2>Booking Form</h2>
                <form id = "booking-form" onSubmit = {this.handleSubmit}>
                <label for="customer_id" ></label>
                <label for="date">Date: </label>
                <input type="date" id="date" value={this.state.date} onChange={this.handleDateChange} required />
                <label for="time">Time: </label>
                <input type="time" id="time" value={this.state.time} min="12:00" max="22:00" onChange={this.handleTimeChange} required />
                <label for="numberOfGuests">Number of guests: </label>
                <input type="number" id="numberOfGuests" value={this.state.numberOfGuests} min="1" max="100" onChange={this.handleGuestChange} required/>
                <label for="tables">Tables booked: </label>
                <input type="checkbox"></input>
                </form>
            </div>
        )
    }

}

export default BookingForm;