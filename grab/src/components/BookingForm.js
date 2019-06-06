import React, {Component} from 'react';

class BookingForm extends Component{

    constructor(props){
        super(props);

        this.state = {
            customerId: '',
            numberOfGuests: '',
            selectedTables: [],
            time: '',
            date: ''
        };

        this.handleCheckboxChange = this.handleCheckboxChange.bind(this);
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    restaurantTableChecklist(){
        const restaurantTableChecklist = this.props.restaurantTables.map((restaurantTable) => {
            return(
                <div className="table-checkbox" key={restaurantTable.id}>
                    <input className="tablebox" type="checkbox" id={restaurantTable.id} name="restaurantTable" value={restaurantTable.id} onChange={this.handleCheckboxChange} />
                    <label className="tablebox" htmlFor="restaurantTable"> Table {restaurantTable.tableNumber} (seats {restaurantTable.seating})</label>
                </div>
            );
        })
        return restaurantTableChecklist;
    }

    customerOptions() {
        const customerOptions = this.props.customers.map((customer) => {
            return (
                <option value={customer.id} key={customer.id}>{customer.name}</option>
            );
        });
        return customerOptions;
    }

    handleInputChange (event) {
        const stateName = event.target.name;
        const value = event.target.value;
        this.setState({
            [stateName]: value
        });
    }

    handleCheckboxChange(event) {
        const baseUrl = 'http://localhost:8080/restaurant-tables/'
        let selectedTables = [...this.state.selectedTables];
        if (event.target.checked) {
            selectedTables.push(baseUrl + event.target.id);
        } else {
            selectedTables.splice(baseUrl + selectedTables.indexOf(event.target.id), 1);
        }
        this.setState({ selectedTables });
    }

    handleSubmit(event) {
        event.preventDefault();

        const payload = {
            "customer": `http://localhost:8080/customers/${ this.state.customerId }`,
            "date": this.state.date,
            "time": this.state.time,
            "numberInParty": this.state.numberOfGuests,
            "restaurantTables": this.state.selectedTables
        };

        this.props.onSubmit(payload)

        this.setState({
            customerId: '',
            numberOfGuests: '',
            selectedTables: [],
            time: '',
            date: ''
    })
}

    render () {
        if (this.props.restaurantTables === null) {
            return null;
        }

        return (
            <div className="booking-form">
                <h2>Booking Form</h2>
                <form id = "booking-form" onSubmit = {this.handleSubmit}>
                    <label htmlFor="customer_id">Customer</label>
                    <select id="customer_id" name="customerId" onChange={this.handleInputChange}>
                    <option disabled default value> -- select a customer -- </option>
                        {this.customerOptions()}
                    </select>

                    <label htmlFor="date">Date: </label>
                    <input type="date" id="date" name="date" value={this.state.date} onChange={this.handleInputChange} required />

                    <label htmlFor="time">Time: </label>
                    <input type="time" id="time" name="time" value={this.state.time} min="12:00" max="22:00" onChange={this.handleInputChange} required />

                    <label htmlFor="numberOfGuests">Number of guests: </label>
                    <input type="number" id="numberOfGuests" name="numberOfGuests" value={this.state.numberOfGuests} min="1" max="100" onChange={this.handleInputChange} required/>
                    <br className = "clear" /><br />
                    <div id="table-box-list">
                    {this.restaurantTableChecklist()}
                    </div>
                    <input type="submit" />
                </form>
            </div>
        )
    }
    }


export default BookingForm;
