import axios from "axios";
import { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [msg, setMsg] = useState("");

    const processLogin = async () => {
        const encodedString = window.btoa(username + ':' + password);
        try {
            const response = await axios.get('http://localhost:8080/api/user/token', {
                headers: { "Authorization": "Basic " + encodedString }
            });
            console.log(response);
            setMsg("Login Success!!!");
        } catch (err) {
            setMsg("Invalid Credentials");
        }
    };

    return (
        <div className="d-flex justify-content-center align-items-center vh-1080 bg-ligh">
            <div className="card" style={{ width: '400px' }}>
                <div className="card-header bg-primary text-white text-center rounded">
                    <h3 className="my-4">AmazeCare Login</h3>
                </div>
                <div className="card-body">
                    {msg && (
                        <div className="alert alert-info text-center" role="alert">
                            {msg}
                        </div>
                    )}
                    <div className="mb-3">
                        <label className="form-label">Username:</label>
                        <input
                            type="text"
                            className="form-control"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            placeholder="Enter your username"
                        />
                    </div>
                    <div className="mb-3">
                        <label className="form-label">Password:</label>
                        <input
                            type="password"
                            className="form-control"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            placeholder="Enter your password"
                        />
                    </div>
                    <div className="d-grid mb-3">
                        <button className="btn btn-primary" onClick={processLogin}>
                            Login
                        </button>
                    </div>
                </div>
                <div className="card-footer text-center">
                    <small>Don't have an account? <a href="#" className="text-primary">Register Account</a></small>
                </div>
            </div>
        </div>
    );
}

export default Login;