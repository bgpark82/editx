import React, { Component } from "react";
import { Route, Redirect } from "react-router-dom";
import AuthService from "./AuthService";

export default class AuthenticatedRoute extends Component {
  render() {
    if (AuthService.isLoggedIn()) return <Route {...this.props} />;
    else return <Redirect to="/login" />;
  }
}
