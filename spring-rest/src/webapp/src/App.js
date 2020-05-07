import React from 'react'
import Navbar from './Navbar'
import { BrowserRouter as Router, Route } from "react-router-dom"
import LoginComponent from './components/authentication/LoginComponent'
import AuthenticatedRoute from './components/authentication/AuthenticatedRoute'
import configureAxiosInterceptors from './components/authentication/AxiosConfig'
import AdminPanel from './components/AdminPanel/AdminPanel'

function App() {
  configureAxiosInterceptors()

  return (
    <Router>
      <div className="container">
        <Route path="/" exact component={LoginComponent} />
        <Route path="/login" exact component={LoginComponent} />
        <AuthenticatedRoute path="/admin" component={AdminPanel} />
      </div>
    </Router>
  );
}

export default App;
