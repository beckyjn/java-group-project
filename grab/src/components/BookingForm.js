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
    }

    render () {
        return (
            <div class="booking-form">
                <h2>Booking Form</h2>
                <form id = "booking-form" onSubmit = {this.handleSubmit}>
                <label for="customer_id" ></label>
                </form>
            </div>
        )
    }

}

export default BookingForm;