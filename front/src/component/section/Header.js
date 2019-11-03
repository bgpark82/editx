import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";
import AuthService from "../../service/AuthService";

class Header extends Component {
  render() {
    let isLoggedIn = AuthService.isLoggedIn();
    const username = AuthService.getUsername();
    return (
      <div>
        {isLoggedIn && <Link to={`/home/${username}`}>Home</Link>}&nbsp;
        {isLoggedIn && <Link to="/page">Page</Link>}&nbsp;
        {!isLoggedIn && <Link to="/login">Login</Link>}&nbsp;
        {isLoggedIn && (
          <Link to="/logout" onClick={AuthService.logout}>
            Logout
          </Link>
        )}
        &nbsp;
        <hr />
      </div>
    );
  }
}

export default withRouter(Header);
