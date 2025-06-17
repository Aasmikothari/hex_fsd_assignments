// src/components/doctor/DoctorNavbar.jsx
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { deleteUserDetails } from "../../store/actions/UserAction";

function DoctorNavbar() {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const name = localStorage.getItem("name");

  const logout = () => {
    localStorage.clear();
    deleteUserDetails(dispatch);
    navigate("/");
  };

  return (
    <nav className="navbar navbar-light bg-light px-6">
      <div className="d-flex align-items-center ms-auto">
        <span className="me-3">Welcome {name}</span>
        <button className="btn btn-outline-danger" onClick={logout}>Logout</button>
      </div>
    </nav>
  );
}

export default DoctorNavbar;