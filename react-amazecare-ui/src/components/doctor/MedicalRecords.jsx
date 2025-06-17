// src/components/doctor/MedicalRecords.jsx
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchDoctorMedicalRecords } from "../../store/actions/MedicalRecordAction";

function MedicalRecords() {
  const dispatch = useDispatch();
  const records = useSelector((state) => state.medicalRecords.records);

  const doctorId = localStorage.getItem("userId");
  const token = localStorage.getItem("token");

  useEffect(() => {
    if (doctorId && token) {
      fetchDoctorMedicalRecords(dispatch)(doctorId, token);
    }
  }, [dispatch, doctorId, token]);

  return (
    <div className="container mt-4">
      <h3 className="mb-4">All Medical Records</h3>

      {records.length === 0 ? (
        <p>No medical records found.</p>
      ) : (
        <table className="table table-bordered table-striped">
          <thead className="table-dark">
            <tr>
              <th>S.No</th>
              <th>Appointment ID</th>
              <th>Patient ID</th>
              <th>Symptoms</th>
              <th>Diagnosis</th>
              <th>Physical Exam</th>
              <th>Treatment Plan</th>
            </tr>
          </thead>
          <tbody>
            {records.map((rec, index) => (
              <tr key={rec.id}>
                <td>{index + 1}</td>
                <td>{rec.appointment?.id || "N/A"}</td>
                <td>{rec.patient?.id || "N/A"}</td>
                <td>{rec.currentSymptoms || rec.symptoms}</td>
                <td>{rec.diagnosis}</td>
                <td>{rec.physicalExamination}</td>
                <td>{rec.treatmentPlan}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default MedicalRecords;