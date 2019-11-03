import React from "react";
import Login from "./component/login/Login";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Home from "./component/home/Home";
import E404 from "./component/error/404";
import Page from "./component/page/Page";
import Header from "./component/section/Header";
import Footer from "./component/section/Footer";
import Logout from "./component/login/Logout";

function App() {
  return (
    <Router>
      <Header />
      <Switch>
        <Route path="/" exact component={Login} />
        <Route path="/login" component={Login} />
        <Route path="/logout" component={Logout} />
        <Route path="/home/:name" component={Home} />
        <Route path="/page" component={Page} />
        <Route component={E404} />
      </Switch>
      <Footer />
    </Router>
  );
}

export default App;
