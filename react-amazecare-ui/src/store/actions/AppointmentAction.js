import axios from "axios";

export const fetchUpcomingAppointments = (dispatch) => () => {
  const doctorId = localStorage.getItem("userId");
  const token = localStorage.getItem("token");

  axios.get(`http://localhost:8080/api/doctors/${doctorId}/appointments/PENDING`, {
    headers: { Authorization: `Bearer ${token}` },
  })
    .then((response) => {
      dispatch({
        type: "FETCH_UPCOMING_APPOINTMENTS",
        payload: response.data
      });
    });
};

export const fetchCompletedAppointments = (dispatch) => () => {
  const doctorId = localStorage.getItem("userId");
  const token = localStorage.getItem("token");

  axios.get(`http://localhost:8080/api/doctors/${doctorId}/appointments/COMPLETED`, {
    headers: { Authorization: `Bearer ${token}` },
  })
    .then((response) => {
      dispatch({
        type: "FETCH_COMPLETED_APPOINTMENTS",
        payload: response.data
      });
    });
};

export const cancelAppointment = (dispatch) => (appointmentId) => {
  const token = localStorage.getItem("token");

  axios.put(`http://localhost:8080/api/appointments/${appointmentId}/cancel`, {}, {
    headers: { Authorization: `Bearer ${token}` },
  })
    .then(() => {
      // Refresh the upcoming list after cancel
      fetchUpcomingAppointments(dispatch)();
    })
    .catch((err) => {
      console.error("Error canceling appointment:", err);
    });
};