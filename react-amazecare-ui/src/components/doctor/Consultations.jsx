//src/components/doctor/Consultations.jsx
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchAllConsultations } from "../../store/actions/ConsultationAction";

function Consultations() {
  const dispatch = useDispatch();
  const consultations = useSelector((state) => state.consultations.consultations);
  const doctorId = localStorage.getItem("userId");
  const token = localStorage.getItem("token");

  useEffect(() => {
    if (doctorId && token) {
      fetchAllConsultations(dispatch)(doctorId, token);
    }
  }, [dispatch, doctorId, token]);

  return (
    <div className="container mt-4">
      <h3 className="mb-4">Consultation Details</h3>

      {consultations.length === 0 ? (
        <p>No consultations available.</p>
      ) : (
        <table className="table table-striped">
          <thead>
            <tr>
              <th>S.No</th>
              <th>Date</th>
              <th>Time</th>
              <th>Patient ID</th>
              <th>Diagnosis</th>
              <th>Symptoms</th>
              <th>Physical Exam</th>
              <th>Treatment Plan</th>
            </tr>
          </thead>
          <tbody>
            {consultations.map((c, i) => (
              <tr key={c.id || i}>
                <td>{i + 1}</td>
                <td>{c.appointmentDate}</td>
                <td>{c.appointmentTime}</td>
                <td>{c.patientId}</td>
                <td>{c.diagnosis}</td>
                <td>{c.symptoms}</td>
                <td>{c.physicalExamination}</td>
                <td>{c.treatmentPlan}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default Consultations;