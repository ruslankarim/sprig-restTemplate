import React, { useState } from 'react'
import classNames from 'classnames'
import { NavLink } from 'react-router-dom'
import AuthenticationService from './components/authentication/AuthenticationService';
import { AuthenticatedSubject } from './components/authentication/AuthenticatedSubject';

const Navbar = () => {

    const [isAuthenticated, setAuthenticated] = useState(AuthenticationService.isUserLoggedIn());
    const [user, setUser] = useState({username: AuthenticationService.getLoggedInUserName()});
    AuthenticatedSubject.subscribe(data => {
        setAuthenticated(true)
        setUser(data)
    })
    let navbar = null

    if(isAuthenticated) {
        navbar =
            <nav>
                <span></span>
                <span>with: {user.username}</span>
            </nav>
    }

    return (
        navbar
    )
}

export default Navbar

