// src/components/Login.jsx
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { useDispatch } from "react-redux";
import { setUserDetails } from "../store/actions/UserAction";
import "../css/login.css";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [msg, setMsg] = useState("");

  const navigate = useNavigate();
  const dispatch = useDispatch();

  const processLogin = async () => {
    const encoded = window.btoa(username + ":" + password);

    try {
      // Step 1: Get token and role
      const response = await axios.get("http://localhost:8080/api/user/token", {
        headers: { Authorization: "Basic " + encoded },
      });

      const { token, role } = response.data;
      localStorage.setItem("token", token);
      localStorage.setItem("role", role);

      // Step 2: Get user details (including user ID)
      const details = await axios.get("http://localhost:8080/api/user/details", {
        headers: { Authorization: "Bearer " + token },
      });

      const user = details.data.user;
      localStorage.setItem("name", user.username);
      localStorage.setItem("userId", user.id); 

      // Step 3: Store in Redux
      setUserDetails(dispatch)({ username: user.username, role });

      // Step 4: Navigate to role-based dashboard
      if (role === "DOCTOR") navigate("/doctor");
      else setMsg("Unauthorized role");

    } catch (err) {
      console.error(err);
      setMsg("Invalid credentials or server error.");
    }
  };

  return (
    <div className="login-container">
      <div className="login-card">
        <h2>AmazeCare Login</h2>
        {msg && <div className="alert alert-danger">{msg}</div>}
        <div className="login-form">
          <input
            type="text"
            className="login-input"
            placeholder="Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <input
            type="password"
            className="login-input"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <button className="login-button" onClick={processLogin}>Login</button>
        </div>
      </div>
    </div>
  );
}

export default Login;