import axios from "axios";

export const fetchAllConsultations = (dispatch) => async (doctorId, token) => {
  console.log("In ConsultationAction...");

  try {
    const appointmentsRes = await axios.get(
      `http://localhost:8080/api/doctors/${doctorId}/appointments/COMPLETED`,
      {
        headers: { Authorization: `Bearer ${token}` }
      }
    );

    const completedAppointments = appointmentsRes.data;

    const promises = completedAppointments.map((appt) =>
      axios
        .get(`http://localhost:8080/api/consultations/appointment/${appt.id}`, {
          headers: { Authorization: `Bearer ${token}` }
        })
        .then((res) => ({
          id: res.data.id,
          diagnosis: res.data.diagnosis,
          symptoms: res.data.symptoms,
          physicalExamination: res.data.physicalExamination,
          treatmentPlan: res.data.treatmentPlan,
          appointmentDate: appt.appointmentDate,
          appointmentTime: appt.appointmentTime,
          patientId: appt.patient?.id || "N/A"
        }))
    );

    const consultationData = await Promise.all(promises);

    dispatch({
      type: "FETCH_ALL_CONSULTATIONS",
      payload: consultationData
    });
  } catch (error) {
    console.error("Error in ConsultationAction:", error);
  }
};