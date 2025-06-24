import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function AddUser() {

    let [msg, setMsg] = useState("");
    let [name, setName] = useState("");
    let [email, setEmail] = useState("");
    let [gender, setGender] = useState("male");
    let [status, setStatus] = useState("active");

    const navigate = useNavigate();

    const addUser = async () => {

        try{
            const res = await axios.post(`https://gorest.co.in/public/v2/users`, {
                name: name,
                email: email,
                gender: gender,
                status: status
            }, 
            {
                headers: {
                    Authorization: 'Bearer 1688f2d2043786fc640233f8af0d98c20523dbed75cef8bc07aea7188dcd3279'
                }
            });
            console.log("Response:", res.data);
            setMsg("User added successfully!!!");
            setTimeout(() => navigate("/users"), 1000);
        }catch (err) {
            setMsg("Failed to add user!")
        }
    };

    return(
        <div className="container mt-4">
            <h2>Add New User</h2>
            {msg && <p className="alert alert-info"></p>}

            <div className="mb-3">
                <label>NAME</label>
                <input className="form-control" value={name} onChange={(e) => setName(e.target.value)} required></input>
            </div>
            <div className="mb-3">
                <label>EMAIL</label>
                <input className="form-control" value={email} onChange={(e) => setEmail(e.target.value)} required></input>
            </div>
            <div className="mb-3">
                <label>GENDER</label>
                <select className="form-control" value={gender} onChange={(e) => setGender(e.target.value)}>
                    <option value="male">MALE</option>
                    <option value="female">FEMALE</option>
                </select>
            </div>
            <div className="mb-3">
                <label>STATUS</label>
                <select className="form-control" value={status} onChange={(e) => setStatus(e.target.value)}>
                    <option value="active">ACTIVE</option>
                    <option value="inactive">INACTIVE</option>
                </select>
            </div>

            <button className="btn btn-primary" onClick={addUser}>Add User</button>
        </div>
    )
}

export default AddUser;