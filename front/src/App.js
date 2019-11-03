import React from "react";
import Login from "./component/login/Login";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Home from "./component/home/Home";
import E404 from "./component/error/404";
import Page from "./component/page/Page";
import Header from "./component/section/Header";
import Footer from "./component/section/Footer";
import Logout from "./component/login/Logout";
import AuthenticatedRoute from "./service/AuthenticatedRoute";

function App() {
  return (
    <Router>
      <Header />
      <Switch>
        <Route path="/" exact component={Login} />
        <Route path="/login" component={Login} />
        <AuthenticatedRoute path="/logout" component={Logout} />
        <AuthenticatedRoute path="/home/:name" component={Home} />
        <AuthenticatedRoute path="/page" component={Page} />
        <Route component={E404} />
      </Switch>
      <Footer />
    </Router>
  );
}

export default App;
