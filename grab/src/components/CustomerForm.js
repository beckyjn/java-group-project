import React, {Component} from 'react';

class CustomerForm extends Component{
    constructor(props){
        super(props);
        
        this.state = {
            name: '',
            phone: '',
            email: '',
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
                "name": this.state.name,
                "phone": this.state.phone,
                "email": this.state.email
            };
    
            fetch('http://localhost:8080/customers', {
                mode: "cors",
                method: "POST",
                headers: {
                  "Content-Type": "application/json",
                  Accept: "application/json",
                  "Access-Control-Allow-Origin": "http://localhost:3000"
                },
                body: JSON.stringify(payload)
            })
            .then(res => res.json())
            .catch(error => {
                console.error(error);
            });

            this.setState({
                    name: '',
                    phone: '',
                    email: '',
            })
        }
    

    render(){
        return(
            <div className="customer-form">
                <h2>New customer?</h2>
                <form id = "customer-form" onSubmit = {this.handleSubmit}>
                    <label htmlFor="name">Name: </label>
                    <input type="text" id="name" name="name" value={this.state.name} onChange={this.handleInputChange} required />
                    
                    <label htmlFor="phone">Phone Number: </label>
                    <input type="text" id="phone" name="phone" value={this.state.phone} onChange={this.handleInputChange} required />
                    
                    <label htmlFor="email">Email address: </label>
                    <input type="text" id="email" name="email" value={this.state.email} onChange={this.handleInputChange} required/>
    
                    <input type="submit" />
                </form>
             </div>
        )
    }

}

export default CustomerForm;
