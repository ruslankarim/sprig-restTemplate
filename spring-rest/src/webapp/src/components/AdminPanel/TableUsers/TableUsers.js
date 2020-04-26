import classnames from 'classnames'
import ModalEditUser from '../../ModalEditUser/ModalEditUser'
import React, {useEffect, useState} from 'react'
import axios from 'axios'
import './TableUsers.css'
import ModalDeleteUser from "../../ModalDeleteUser/ModalDeleteUser";

const TableUsers = () => {

    const [users, setUsers] = useState([]);

    useEffect(() => {
        getAllUsers()
    }, [])

    const getAllUsers = () => {
        axios.get('/admin/allusers')
            .then(response => {
                setUsers(response.data)
            })
    }

    return (
        <table className={classnames('table', 'table-striped')}>
            <caption className={classnames('bg-light', 'text-dark', 'paddingpanel')}>
                <h3>All users</h3>
            </caption>
            <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Email</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            {
                users.map( user => (
                    <tr key={user.id}>
                        <td>{user.id}</td>
                        <td>{user.firstName}</td>
                        <td>{user.lastName}</td>
                        <td>{user.age}</td>
                        <td>{user.email}</td>
                        <td>{
                            user.roles.map(role => role + ' ')
                        }</td>
                        <td>
                            <ModalEditUser user={user}/>
                        </td>
                        <td>
                            <ModalDeleteUser user={user}/>
                        </td>
                    </tr>
                ))
            }
            </tbody>
        </table>
    )
}

export default TableUsers