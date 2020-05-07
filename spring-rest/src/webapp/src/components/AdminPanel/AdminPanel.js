import React, { useState } from 'react'
import AdminLinks from "./AdminLinks/AdminLinks";
import TableUsers from "./TableUsers/TableUsers";
import NewUser from "./NewUser/NewUser";
import Navbar from "../../Navbar";

const AdminPanel = () => {

    const [values, setValues] = useState({
        isNewUserForm: false,
    })

    const toggleUserForm = () => {
        setValues({
            ...values,
            isNewUserForm: true,
        })
    }

    const toggleUserTable = () => {
        setValues({
            ...values,
            isNewUserForm: false,
        })
    }
    return (
        <div className='container'>
            <Navbar />
            <AdminLinks toggleUserForm={toggleUserForm}
                        toggleUserTable={toggleUserTable}
            />
            {
                !values.isNewUserForm ?
                <TableUsers/> :
                <NewUser toggleUserForm={toggleUserForm}
                         toggleUserTable={toggleUserTable}/>
            }
        </div>

    )
}
export default AdminPanel