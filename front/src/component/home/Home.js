import React, { Component } from "react";
import { Link } from "react-router-dom";

export default class Home extends Component {
  render() {
    return (
      <div>
        home {this.props.match.params.name}
        <Link to="/page">페이지로 가기</Link>
      </div>
    );
  }
}
