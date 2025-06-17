import { Link } from "react-router-dom";

function DoctorSidebar() {
  return (
    <nav id="sidebar-wrapper">
      <ul className="nav sidebar-nav">
        <div className="sidebar-header">
          <div className="sidebar-brand">
            <a href="#">AmazeCare Doctor</a>
          </div>
        </div>
        <li><Link to="/doctor">🏠 Dashboard Home</Link></li>
        <li><Link to="/doctor/appointments">📅 Appointments</Link></li>
        <li><Link to="/doctor/consultations">🩺 Consultations</Link></li>
        <li><Link to="/doctor/medicalrecords">📄 Medical Records</Link></li>
        <li><Link to="/doctor/tests">🧪 Test Results</Link></li>
        <li><a href="#contact">📨 Contact Admin</a></li>
      </ul>
    </nav>
  );
}

export default DoctorSidebar;