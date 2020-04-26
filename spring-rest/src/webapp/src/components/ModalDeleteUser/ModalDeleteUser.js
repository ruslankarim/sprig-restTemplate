import React, { useState } from 'react'
import { Modal, Button } from 'react-bootstrap'
import axios from "axios";

const ModalDeleteUser = ({user}) => {
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true)

    const deleteCustomer = (id) => {
        axios.delete("/admin/deleteuser/" + id)
            .then(response => {
                handleClose()
            })
            .catch(error => {
                alert.error('Error: could not delete customer')
            })
    }
    return (
        <>
            <Button variant="danger" onClick={handleShow} >
                Delete
            </Button>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Delete user</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <form id='edit-form-user'>
                        <div className="form-group">
                            <label htmlFor="id">ID</label>
                            <input type='text' className="form-control" name="id" value={user.id} readOnly/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="firstName">First name</label>
                            <input type='text' className="form-control" name="firstName" value={user.firstName} readOnly/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="lastName">Last name</label>
                            <input type='text' className="form-control" name="lastName" value={user.lastName} readOnly/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="lastName">Last name</label>
                            <input type='text' className="form-control" name="lastName" value={user.lastName} readOnly/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="age">Age</label>
                            <input type='text' className="form-control" name="age" value={user.age} readOnly/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="email">Email</label>
                            <input type='text' className="form-control" name="email" value={user.email} readOnly/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input type='text' className="form-control" name="password" value={user.password} readOnly/>
                        </div>
                        <div className="form-group form-check">
                            <input type="checkbox" name="isAdmin" className="form-check-input"
                                   id="admin-new-user" checked={user.isAdmin} readOnly/>
                            <label className="form-check-label" htmlFor="admin-new-user">Admin</label>
                        </div>
                        <div className="form-group form-check">
                            <input type="checkbox" name="isUser" className="form-check-input"
                                   id="user-new-user" checked={user.isUser} readOnly/>
                            <label className="form-check-label" htmlFor="user-new-user">User</label>
                        </div>
                    </form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" type='submit' form='edit-form-user' onClick={() => {deleteCustomer (user.id)}}>
                        Delete user
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    )
}

export default ModalDeleteUser