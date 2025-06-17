import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  fetchUpcomingAppointments,
  fetchCompletedAppointments,
  cancelAppointment
} from "../../store/actions/AppointmentAction";

function Appointments() {
  const dispatch = useDispatch();
  const upcoming = useSelector((state) => state.appointment.upcoming);
  const completed = useSelector((state) => state.appointment.completed);

  useEffect(() => {
    fetchUpcomingAppointments(dispatch)();
    fetchCompletedAppointments(dispatch)();
  }, [dispatch]);

  const handleCancel = (id) => {
    if (window.confirm("Are you sure you want to cancel this appointment?")) {
      cancelAppointment(dispatch)(id);
    }
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-5">Consultation Details</h2>
      <h3 className="mb-3">Upcoming Appointments</h3>
      {upcoming.length === 0 ? (
        <p>No upcoming appointments.</p>
      ) : (
        <table className="table table-bordered">
          <thead className="table-light">
            <tr>
              <th>S.No</th>
              <th>Date</th>
              <th>Time</th>
              <th>Reason</th>
              <th>Status</th>
              <th>Patient ID</th>
              <th>Actions</th> {/* Added column */}
            </tr>
          </thead>
          <tbody>
            {upcoming.map((appt, i) => (
              <tr key={appt.id}>
                <td>{i + 1}</td>
                <td>{appt.appointmentDate}</td>
                <td>{appt.appointmentTime}</td>
                <td>{appt.reason}</td>
                <td>{appt.status}</td>
                <td>{appt.patient?.id || "N/A"}</td>
                <td>
                  <button
                    className="btn btn-sm btn-danger"
                    onClick={() => handleCancel(appt.id)}
                  >
                    Cancel
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}

      <h3 className="mt-5 mb-3">Completed Appointments</h3>
      {completed.length === 0 ? (
        <p>No completed appointments.</p>
      ) : (
        <table className="table table-bordered">
          <thead className="table-light">
            <tr>
              <th>S.No</th>
              <th>Date</th>
              <th>Time</th>
              <th>Reason</th>
              <th>Status</th>
              <th>Patient ID</th>
            </tr>
          </thead>
          <tbody>
            {completed.map((appt, i) => (
              <tr key={appt.id}>
                <td>{i + 1}</td>
                <td>{appt.appointmentDate}</td>
                <td>{appt.appointmentTime}</td>
                <td>{appt.reason}</td>
                <td>{appt.status}</td>
                <td>{appt.patient?.id || "N/A"}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default Appointments;