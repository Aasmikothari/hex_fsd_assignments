import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login";
import DoctorDashboard from "./components/doctor/DoctorDashboard";
// For patient & admin dashboard, create these components similarly if needed
// import PatientDashboard from "./components/patient/PatientDashboard";
// import AdminDashboard from "./components/admin/AdminDashboard";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/doctor/dashboard" element={<DoctorDashboard />} />
        {/* Future routes if needed */}
        {/* <Route path="/patient/dashboard" element={<PatientDashboard />} /> */}
        {/* <Route path="/admin/dashboard" element={<AdminDashboard />} /> */}
      </Routes>
    </BrowserRouter>
  );
}

export default App;