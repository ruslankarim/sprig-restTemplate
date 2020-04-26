import React, { useState, useEffect } from 'react'
import { Modal, Button } from 'react-bootstrap'
import axios from "axios";

const ModalEditUser = ({user}) => {
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true)
    const [values, setValues] = useState({
        id: user.id,
        firstName: user.firstName,
        lastName: user.lastName,
        age: user.age,
        email: user.email,
        password: user.password,
        isAdmin: user.isAdmin,
        isUser: user.isUser,
    })
    const handleOnChange = (e) => {
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
        axios.post('/admin/updateuser', values)
            .then(function (response) {
            })
    }
    return (
        <>
            <Button variant="primary" onClick={handleShow} >
                Edit
            </Button>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Edit user</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <form method='post' id='edit-form-user' onSubmit={onSubmit}>
                        <div className="form-group">
                            <label htmlFor="id">ID</label>
                            <input type='text' className="form-control" name="id" value={user.id} readOnly/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="firstName">First name</label>
                            <input type='text' className="form-control" name="firstName" value={values.firstName} onChange={handleOnChange} />
                        </div>
                        <div className="form-group">
                            <label htmlFor="lastName">Last name</label>
                            <input type='text' className="form-control" name="lastName" value={values.lastName} onChange={handleOnChange} />
                        </div>
                        <div className="form-group">
                            <label htmlFor="lastName">Last name</label>
                            <input type='text' className="form-control" name="lastName" value={values.lastName} onChange={handleOnChange} />
                        </div>
                        <div className="form-group">
                            <label htmlFor="age">Age</label>
                            <input type='text' className="form-control" name="age" value={values.age} onChange={handleOnChange} />
                        </div>
                        <div className="form-group">
                            <label htmlFor="email">Email</label>
                            <input type='text' className="form-control" name="email" value={values.email} onChange={handleOnChange} />
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input type='text' className="form-control" name="password" value={values.password} onChange={handleOnChange} />
                        </div>
                        <div className="form-group form-check">
                            <input type="checkbox" name="isAdmin" className="form-check-input"
                                   id="admin-new-user" onChange={handleOnChange} checked={values.isAdmin}/>
                            <label className="form-check-label" htmlFor="admin-new-user">Admin</label>
                        </div>
                        <div className="form-group form-check">
                            <input type="checkbox" name="isUser" className="form-check-input"
                                   id="user-new-user" onChange={handleOnChange} checked={values.isUser}/>
                            <label className="form-check-label" htmlFor="user-new-user">User</label>
                        </div>
                    </form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" type='submit' form='edit-form-user' onClick={handleClose}>
                        Save Changes
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    )
}

export default ModalEditUser