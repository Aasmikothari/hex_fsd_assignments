import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [msg, setMsg] = useState("");
  const navigate = useNavigate();

  const processLogin = async () => {
    const encoded = window.btoa(username + ":" + password);

    try {
      // Step 1: Get Token and Role
      const response = await axios.get("http://localhost:8080/api/user/token", {
        headers: {
          Authorization: "Basic " + encoded
        }
      });

      const token = response.data.token;
      const role = response.data.role;

      localStorage.setItem("token", token);
      localStorage.setItem("role", role);

      // Step 2: Optionally fetch name/details
      const details = await axios.get("http://localhost:8080/api/user/details", {
        headers: {
          Authorization: "Bearer " + token
        }
      });

      const name = details.data.user.username;
      localStorage.setItem("name", name);

      // Step 3: Redirect based on role
      switch (role) {
        case "DOCTOR":
          navigate("/doctor/dashboard");
          break;
        case "PATIENT":
          navigate("/patient-dashboard");
          break;
        case "ADMIN":
          navigate("/admin-dashboard");
          break;
        default:
          setMsg("Unknown Role. Contact Support.");
      }

      setMsg("Login successful!");
    } catch (err) {
      console.error(err);
      setMsg("Invalid credentials or server error.");
    }
  };

  return (
    <div className="container mt-5">
      <h2>AmazeCare Login</h2>
      {msg && <div className="alert alert-info">{msg}</div>}
      <div className="form-group">
        <label>Enter Username:</label>
        <input
          type="text"
          className="form-control"
          onChange={(e) => setUsername(e.target.value)}
          value={username}
        />
      </div>
      <div className="form-group mt-3">
        <label>Enter Password:</label>
        <input
          type="password"
          className="form-control"
          onChange={(e) => setPassword(e.target.value)}
          value={password}
        />
      </div>
      <div className="form-group mt-3">
        <button className="btn btn-primary" onClick={processLogin}>
          Login
        </button>
      </div>
      <div className="mt-3">
        Don't have an Account? <a href="/signup">Sign Up here</a>
      </div>
    </div>
  );
}

export default Login;