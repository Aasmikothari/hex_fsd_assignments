// src/store/actions/MedicalRecordAction.js
import axios from "axios";

export const fetchDoctorMedicalRecords = (dispatch) => (doctorId, token) => {
  console.log("Fetching medical records for doctor...");

  axios
    .get(`http://localhost:8080/api/medical-records/doctor/${doctorId}`, {
      headers: { Authorization: `Bearer ${token}` },
    })
    .then((res) => {
      dispatch({
        type: "FETCH_DOCTOR_MEDICAL_RECORDS",
        payload: res.data,
      });
    })
    .catch((err) => {
      console.error("Error fetching medical records:", err);
    });
};