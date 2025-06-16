import { useState } from "react";
import { useNavigate } from "react-router-dom";

function DoctorNavbar() {
    const [name] = useState(localStorage.getItem('name'));
    const navigate = useNavigate();

    const logout = () => {
        localStorage.clear();
        navigate("/");
    }

    return (
        <nav className="navbar navbar-light bg-light justify-content-between">
            <div className="navbar-brand">AmazeCare Doctor</div>
            <div className="form-inline mt-2 mb-4">
                Welcome {name} &nbsp;&nbsp;&nbsp;
                <button className="btn btn-outline-danger" onClick={logout}>Logout</button>
            </div>
        </nav>
    )
}

export default DoctorNavbar;