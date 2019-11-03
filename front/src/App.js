import React from "react";
import Login from "./component/login/Login";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Home from "./component/home/Home";
import E404 from "./component/error/404";
import Page from "./component/page/Page";

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/" exact component={Login} />
        <Route path="/home/:name" component={Home} />
        <Route path="/page" component={Page} />
        <Route component={E404} />
      </Switch>
    </Router>
  );
}

export default App;
