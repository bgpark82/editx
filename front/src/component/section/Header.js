import React, { Component } from "react";
import { Link } from "react-router-dom";
import AuthService from "../../service/AuthService";

export default class Header extends Component {
  render() {
    return (
      <div>
        <Link to="/home">Home</Link>&nbsp;
        <Link to="/page">Page</Link>&nbsp;
        <Link to="/login">Login</Link>&nbsp;
        <Link to="/logout" onClick={AuthService.logout}>
          Logout
        </Link>
        &nbsp;
        <hr />
      </div>
    );
  }
}
