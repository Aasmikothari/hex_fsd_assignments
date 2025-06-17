// src/components/doctor/Home.jsx
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchDoctorProfile } from "../../store/actions/DoctorAction";

function Home() {
  const dispatch = useDispatch();
  const doctor = useSelector((state) => state.doctor.doctor);
  const userId = localStorage.getItem("userId");
  const token = localStorage.getItem("token");

  useEffect(() => {
    if (userId && token) {
      fetchDoctorProfile(dispatch)(userId, token);
    }
  }, [dispatch, userId, token]);

  return (
    <div className="container mt-4">
      <h2>Welcome to the AmazeCare Doctor Dashboard</h2>
      <p>You can manage appointments, consultations, medical records, and more from here.</p>

      {doctor ? (
        <div className="card mt-4">
          <div className="card-body">
            <h4 className="card-title">{doctor.name}</h4>
            <p><strong>Specialization:</strong> {doctor.specialty}</p>
            <p><strong>Experience:</strong> {doctor.experience} years</p>
            <p><strong>Qualification:</strong> {doctor.qualification}</p>
            <p><strong>Designation:</strong> {doctor.designation}</p>
          </div>
        </div>
      ) : (
        <p>Loading profile...</p>
      )}
    </div>
  );
}

export default Home;