import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function UserList() {

    let [msg, setMsg] = useState("") //string
    let [users, setUsers] = useState([]) //array

    const navigate = useNavigate();

    //get api - to fetch users
    useEffect(() => {
        const fetchUsers = async () => {
            try {
                const res = await axios.get(`https://gorest.co.in/public/v2/users`); //response
                setUsers(res.data); //storing data into setUsers
            } catch (err) {
                setMsg("Failed to Load Users");
            }
        }

        fetchUsers(); //to call the function

    }, []); 


    //delete api - to delete user
    const deleteUser = async (id) => { //id taken as input
        try {
            await axios.delete(`https://gorest.co.in/public/v2/users/${id}`, {
                headers: {
                    Authorization: 'Bearer 1688f2d2043786fc640233f8af0d98c20523dbed75cef8bc07aea7188dcd3279'
                }
            });
            setUsers(users.filter(u => u.id !== id));
            setMsg("User deleted sucessfully!!!");
        } catch (err) {
            setMsg("Failed to delete User!")
        }
    }

    return (
        <div className="container mt-4">
            <h2 className="text-center mb-4">User List</h2>

            {msg && <p className="alert alert-info">{msg}</p>}

            <div>
                <table className="table table-bordered">
                    <thead className="table-light">
                        <tr>
                            <th>ID</th>
                            <th>NAME</th>
                            <th>EMAIL</th>
                            <th>GENDER</th>
                            <th>STATUS</th>
                            <th>EDIT</th>
                            <th>DELETE</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.map(user => (
                            <tr key= {user.id}>
                                <td>{user.id}</td>
                                <td>{user.name}</td>
                                <td>{user.email}</td>
                                <td>{user.gender}</td>
                                <td>{user.status}</td>
                                <td>
                                    <button className="btn btn-primary btn-sm" onClick={() => navigate(`/edit-user/${user.id}`)}>
                                        Edit
                                    </button>
                                </td>
                                <td>
                                    <button className="btn btn-danger btn-sm" onClick={() => deleteUser(user.id)}>
                                        Delete
                                    </button>
                                </td> 
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default UserList;