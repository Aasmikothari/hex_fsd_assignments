// src/store/actions/DoctorAction.js
import axios from "axios";

export const fetchDoctorProfile = (dispatch) => (userId, token) => {
  axios.get(`http://localhost:8080/api/doctors/user/${userId}`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  })
    .then((res) => {
      dispatch({
        type: "FETCH_DOCTOR_PROFILE",
        payload: res.data,
      });
    })
    .catch((err) => {
      console.error("Error fetching doctor profile:", err);
    });
};