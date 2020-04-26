import React, { useState, useEffect } from 'react'
import {Link} from "react-router-dom";

const AdminLinks = ({toggleUserForm, toggleUserTable}) => {
    return (
        <div className='panel'>
            <h1>Admin panel</h1>
            <ul className='nav nav-tabs'>
                <li className='nav-item'>
                    <Link to='/admin' className='nav-link' onClick={toggleUserTable}>User table</Link>
                </li>
                <li className='nav-item'>
                    <Link to='/admin/new' className='nav-link' onClick={toggleUserForm}>New user</Link>
                </li>
            </ul>
        </div>
    )
}

export default AdminLinks