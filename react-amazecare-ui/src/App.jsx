import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login";
import DoctorDashboard from "./components/doctor/DoctorDashboard";
import Home from "./components/doctor/Home";
import Appointments from "./components/doctor/Appointments";
import Consultations from "./components/doctor/Consultations"; 
import MedicalRecords from "./components/doctor/MedicalRecords";
import Tests from "./components/doctor/Tests";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/doctor" element={<DoctorDashboard />}>
          <Route index element={<Home />} />
          <Route path="appointments" element={<Appointments />} />
          <Route path="consultations" element={<Consultations />} />
          <Route path="medicalrecords" element={<MedicalRecords />} /> 
          <Route path="tests" element={<Tests />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;