import { Link } from "react-router-dom";

function DoctorSidebar() {
    return (
        <nav className="navbar navbar-inverse fixed-top" id="sidebar-wrapper" role="navigation">
            <ul className="nav sidebar-nav">
                <div className="sidebar-header">
                    <div className="sidebar-brand">
                        <a href="#">AmazeCare Doctor</a>
                    </div>
                </div>
                <li><Link to="/doctor">Dashboard Home</Link></li>
                <li><Link to="/doctor/appointments">View Appointments</Link></li>
                <li><Link to="/doctor/consultations">Consultation Details</Link></li>
                <li><Link to="/doctor/medicalrecords">Medical Records</Link></li>
                <li><Link to="/doctor/tests">Test Results</Link></li>
                <li><a href="#contact">Contact Admin</a></li>
            </ul>
        </nav>
    )
}

export default DoctorSidebar;