import React, { Component } from "react";

export default class Login extends Component {
  state = {
    username: "",
    password: "",
    isLoginSuccess: false,
    isLoginFail: false
  };

  handleLogin = e => {
    this.setState({ [e.target.name]: e.target.value });
    console.log(this.state);
  };

  clickLogin = () => {
    if (this.state.username === "1234" && this.state.password === "1234") {
      this.setState({ isLoginSuccess: true });
      this.setState({ isLoginFail: false });
      console.log(this);
      this.props.history.push("/home");
    } else {
      this.setState({ isLoginSuccess: false });
      this.setState({ isLoginFail: true });
    }
  };

  render() {
    return (
      <div>
        {this.state.isLoginSuccess && <div>로그인 성공</div>}
        {this.state.isLoginFail && <div>로그인 실패</div>}
        username :
        <input type="text" name="username" onChange={this.handleLogin} />
        password :
        <input type="text" name="password" onChange={this.handleLogin} />
        <button onClick={this.clickLogin}>login</button>
      </div>
    );
  }
}
