import React from "react";

class EditContact extends React.Component {
  constructor(props) {
    super(props);
    const { customerId, firstName, lastName, email, mobile, address, city, pincode  } = props.location.state.contact;
    this.state = {
      customerId,
      firstName,
      lastName,
      email,
      mobile,
      address,
      city,
      pincode
    };
  }

  update = (e) => {
    e.preventDefault();
    if (this.state.customerId === "" ||this.state.firstName === "" ||this.state.lastName === "" || this.state.email === ""||
    this.state.mobile === ""|| this.state.address === ""|| this.state.city === ""
    || this.state.pincode === "") {
      alert("ALl the fields are mandatory!");
      return;
    }
    this.props.updateContactHandler(this.state);
    this.setState({ 
      customerId:"",
      firstName: "",
    lastName:"",
     email: "" ,
     mobile:"",
    address:"",
    city:"",
    pincode:""});
    this.props.history.push("/");
  };
  render() {
    return (
      <div className="ui main">
        <h2>Edit Contact</h2>
        <form className="ui form" onSubmit={this.update}>
          <div className="field">
            <label>CustomerId</label>
            <input
              type="number"
              name="customerId"
              placeholder="customerId"
              value={this.state.customerId}
              onChange={(e) => this.setState({ customerId: e.target.value })}
            />
          </div>
          <div className="field">
            <label>FirstName</label>
            <input
              type="text"
              name="firstName"
              placeholder="firstName"
              value={this.state.firstName}
              onChange={(e) => this.setState({ firstName: e.target.value })}
            />
          </div>
          <div className="field">
            <label>LastName</label>
            <input
              type="text"
              name="lastName"
              placeholder="lastName"
              value={this.state.lastName}
              onChange={(e) => this.setState({ lastName: e.target.value })}
            />
          </div>
          <div className="field">
            <label>Email</label>
            <input
              type="text"
              name="email"
              placeholder="Email"
              value={this.state.email}
              onChange={(e) => this.setState({ email: e.target.value })}
            />
          </div>
          <div className="field">
            <label>Mobile</label>
            <input
              type="text"
              name="mobile"
              placeholder="mobile"
              value={this.state.mobile}
              onChange={(e) => this.setState({ mobile: e.target.value })}
            />
          </div>
          <div className="field">
            <label>Address</label>
            <input
              type="text"
              name="address"
              placeholder="address"
              value={this.state.address}
              onChange={(e) => this.setState({ address: e.target.value })}
            />
          </div>
          <div className="field">
            <label>City</label>
            <input
              type="text"
              name="city"
              placeholder="city"
              value={this.state.city}
              onChange={(e) => this.setState({ city: e.target.value })}
            />
          </div>
          <div className="field">
            <label>Pincode</label>
            <input
              type="text"
              name="pincode"
              placeholder="pincode"
              value={this.state.pincode}
              onChange={(e) => this.setState({ pincode: e.target.value })}
            />
          </div>
          <button className="ui button blue">Update</button>
        </form>
      </div>
    );
  }
}

export default EditContact;
