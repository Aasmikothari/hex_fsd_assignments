// src/components/doctor/DoctorDashboard.jsx
import { useEffect, useRef, useState } from "react";
import { Outlet, useNavigate } from "react-router-dom";
import DoctorNavbar from "./DoctorNavbar";
import DoctorSidebar from "./DoctorSidebar";
import "../../css/doctor.css";

function DoctorDashboard() {
  const navigate = useNavigate();
  const [isClosed, setIsClosed] = useState(true);
  const overlayRef = useRef(null);
  const wrapperRef = useRef(null);

  useEffect(() => {
    const token = localStorage.getItem("token");
    const role = localStorage.getItem("role");
    if (!token || role !== "DOCTOR") {
      navigate("/");
    }
  }, [navigate]);

  const handleHamburgerClick = () => {
    const newState = !isClosed;
    setIsClosed(newState);
    if (overlayRef.current) overlayRef.current.style.display = newState ? "none" : "block";
    if (wrapperRef.current) wrapperRef.current.classList.toggle("toggled");
  };

  return (
    <div className="container-fluid">
      <DoctorNavbar />
      <div id="wrapper" ref={wrapperRef}>
        <div className="overlay" ref={overlayRef}></div>
        <DoctorSidebar />
        <div id="page-content-wrapper">
          <button
            className={`hamburger animated fadeInLeft ${isClosed ? "is-closed" : "is-open"}`}
            onClick={handleHamburgerClick}
          >
            <span className="hamb-top" />
            <span className="hamb-middle" />
            <span className="hamb-bottom" />
          </button>
          <div className="container">
            <Outlet /> {/* Nested routes render here */}
          </div>
        </div>
      </div>
    </div>
  );
}

export default DoctorDashboard;