import React from "react";

class AddContact extends React.Component {
  state = {
    firstName: "",
    lastName: "",
    email: "",
    mobile:"",
    address:"",
    city:"",
    pincode:""
  };

  add = (e) => {
    e.preventDefault();
    if (this.state.firstName === "" ||this.state.lastName === "" || this.state.email === ""||
     this.state.mobile === ""|| this.state.address === ""|| this.state.city === ""
     || this.state.pincode === "") {
      alert("ALL the fields are mandatory!");
      return;
    }
    this.props.addContactHandler(this.state);
    this.setState({ firstName: "",
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
        <h2>Add Contact</h2>
        <form className="ui form" onSubmit={this.add}>
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
          <button className="ui button blue">Add</button>
        </form>
      </div>
    );
  }
}

export default AddContact;
