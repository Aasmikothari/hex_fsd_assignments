import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchAllTestsForDoctor } from "../../store/actions/TestAction";

function Tests() {
  const dispatch = useDispatch();
  const tests = useSelector((state) => state.tests.tests);
  const doctorId = localStorage.getItem("userId");
  const token = localStorage.getItem("token");

  useEffect(() => {
    if (doctorId && token) {
      fetchAllTestsForDoctor(dispatch)(doctorId, token);
    }
  }, [dispatch, doctorId, token]);

  return (
    <div className="container mt-4">
      <h3 className="mb-4">Test Results</h3>

      {tests.length === 0 ? (
        <p>No test results available.</p>
      ) : (
        <table className="table table-bordered">
          <thead className="table-dark">
            <tr>
              <th>S.No</th>
              <th>Test Name</th>
              <th>Result</th>
              <th>Status</th>
              <th>Appointment ID</th>
            </tr>
          </thead>
          <tbody>
            {tests.map((t, index) => (
              <tr key={t.id || index}>
                <td>{index + 1}</td>
                <td>{t.testName}</td>
                <td>{t.result}</td>
                <td>{t.status}</td>
                <td>{t.appointment?.id || "N/A"}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default Tests;