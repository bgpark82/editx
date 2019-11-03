import React from "react";
import Login from "./component/login/Login";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Home from "./component/home/Home";

function App() {
  return (
    <Router>
      <Route path="/" exact component={Login} />
      <Route path="/home" component={Home} />
    </Router>
  );
}

export default App;
