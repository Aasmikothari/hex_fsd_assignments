// src/store/actions/TestAction.js
import axios from "axios";

export const fetchAllTestsForDoctor = (dispatch) => (doctorId, token) => {
  console.log("Fetching test results...");

  axios.get(`http://localhost:8080/api/tests/status/COMPLETED`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  })
    .then((res) => {
      dispatch({
        type: "FETCH_ALL_TESTS",
        payload: res.data,
      });
    })
    .catch((err) => {
      console.error("Error fetching test results:", err);
    });
};
