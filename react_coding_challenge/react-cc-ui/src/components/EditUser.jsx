import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

function EditUser() {

    const { id } = useParams();
    let [msg, setMsg] = useState("")
    let [name, setName] = useState("");
    let [email, setEmail] = useState("");
    let [gender, setGender] = useState("male");
    let [status, setStatus] = useState("active");

    const navigate = useNavigate();

    useEffect(() => {
        const fetchUser = async () => {
            try {
                const res = await axios.get(`https://gorest.co.in/public/v2/users/${id}`);
                const user = res.data;
            } catch (err) {
                setMsg("Failed to load user!");
            }
        };
        fetchUser();
    }, [id]);

    //put api - update user
    const updateUser = async () => {
        try {
            const res = await axios.put(`https://gorest.co.in/public/v2/users/${id}`, {
                name : name,
                email : email,
                gender : gender,
                status : status
            }, {
                headers: {
                    Authorization: 'Bearer 1688f2d2043786fc640233f8af0d98c20523dbed75cef8bc07aea7188dcd3279'
                }
            });
            setMsg("User updated successfully!!!");
            setTimeout(() => navigate("/users"), 1000);
        } catch (err) {
            setMsg("Failed to update user!");
        }
    };

    return (
        <div className="container mt-4">
            <h2>Edit User</h2>
            {msg && <p className="alert alert-info">{msg}</p>}

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

            <button className="btn btn-primary" onClick={updateUser}>Update User</button>       
        </div>
    )

}

export default EditUser;