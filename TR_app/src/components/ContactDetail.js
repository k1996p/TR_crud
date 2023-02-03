import React from "react";
import { Link } from "react-router-dom";
import user from "../images/user.jpg";

const ContactDetail = (props) => {
  const { customerId, firstName, lastName,mobile,address,city,pincode, email } = props.location.state.contact;
  return (
    <div className="main">
      <div className="ui card centered">
        <div className="image">
          <img src={user} alt="user" />
        </div>
        <div className="content">
          <div className="header">{customerId}<span>&#41;</span> {firstName} {lastName}</div>
          <div className="description">{email}</div>
          <div className="description">{mobile}</div>
          <div className="description">{address},{city},{pincode}</div>
        </div>
      </div>
      <div className="center-div">
        <Link to="/">
          <button className="ui button blue center">
            Back to Contact List
          </button>
        </Link>
      </div>
    </div>
  );
};

export default ContactDetail;
