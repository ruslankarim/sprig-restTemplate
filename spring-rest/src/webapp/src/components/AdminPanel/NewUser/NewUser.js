import React, {useEffect, useState} from "react";
import { useHistory } from "react-router-dom";
import classnames from "classnames";
import './NewUser.css'
import axios from "axios"

const NewUser = ({toggleUserTable}) => {
    let history = useHistory();

    const [values, setValues] = useState({
        firstName: '',
        lastName: '',
        age: '',
        email: '',
        password: '',
        isAdmin: false,
        isUser: false,
    })

    const onChange = (e) => {
        if (e.target.name !== 'isAdmin' && e.target.name !== 'isUser'){
            setValues({
                ...values,
                [e.target.name]: e.target.value,
            })
        }else{
            setValues({
                ...values,
                [e.target.name]: e.target.checked,
            })
        }
    }

    const onSubmit = (e) => {
        e.preventDefault()
        axios.post('/admin/new', values)
            .then(function (response) {
                history.push("/admin")
                toggleUserTable()
            })
    }

    return (
        <table className={classnames('table', 'table-striped')}>
            <caption className={classnames('bg-light', 'text-dark', 'paddingpanel')}>
                <h3>Add new user</h3>
            </caption>
            <tbody>
                <tr>
                    <td className="td-new-user">
                        <form method="post" action="/admin/new" onSubmit={onSubmit}>
                            <div className="form-group">
                                <label htmlFor="first_name">First name</label>
                                <input required type="text"
                                       name="firstName"
                                       id="firstName"
                                       className="form-control"
                                       onChange={onChange}

                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="last_name">Last name</label>
                                <input required type="text" name="lastName" id="lastName" className="form-control" onChange={onChange}/>
                            </div>
                            <div className="form-group">
                                <label htmlFor="age">Age</label>
                                <input required type="number" id="age" name="age" className="form-control" onChange={onChange}/>
                            </div>
                            <div className="form-group">
                                <label htmlFor="email">Email</label>
                                <input required type="email" id="email" name="email" className="form-control" onChange={onChange}/>
                            </div>
                            <div className="form-group">
                                <label htmlFor="password">Password</label>
                                <input required type="password" id="password" name="password" className="form-control" onChange={onChange}/>
                            </div>
                            <p>Role</p><br/>
                            <div className="form-group form-check">
                                <input type="checkbox" name="isAdmin" className="form-check-input"
                                       id="admin-new-user" onChange={onChange} checked={values.isAdmin}/>
                                <label className="form-check-label" htmlFor="admin-new-user">Admin</label>
                            </div>
                            <div className="form-group form-check">
                                <input type="checkbox" name="isUser" className="form-check-input"
                                       id="user-new-user" onChange={onChange} checked={values.isUser}/>
                                    <label className="form-check-label" htmlFor="user-new-user">User</label>
                            </div>
                            <button className="btn btn-primary" type="submit"
                                    value="Add new user">Add new user
                            </button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    )
}

export default NewUser