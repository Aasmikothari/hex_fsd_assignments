import { useEffect, useRef, useState } from 'react';
import { Outlet, useNavigate } from 'react-router-dom';
import '../../css/doctor.css'; // Using LMS-style CSS
import Sidebar from './Sidebar';
import Navbar from './Navbar';

function DoctorDashboard() {

    const navigate = useNavigate();

    useEffect(() => {
        let token = localStorage.getItem('token');
        if (!token)
            navigate("/");
    }, []);

    const [isClosed, setIsClosed] = useState(true);
    const overlayRef = useRef(null);
    const wrapperRef = useRef(null);

    const handleHamburgerClick = () => {
        const newState = !isClosed;
        setIsClosed(newState);

        if (overlayRef.current) {
            overlayRef.current.style.display = newState ? 'none' : 'block';
        }
        if (wrapperRef.current) {
            wrapperRef.current.classList.toggle('toggled');
        }
    };

    return (
        <div className='container-fluid'>
            <div className='row'>
                <div className='col-lg-12'>
                    <Navbar />
                </div>
                <div className='col-lg-12'>
                    <div id="wrapper" ref={wrapperRef}>
                        <div
                            className="overlay"
                            ref={overlayRef}
                            style={{ display: isClosed ? 'none' : 'block' }}
                        ></div>

                        <Sidebar />

                        <div id="page-content-wrapper">
                            <button
                                type="button"
                                className={`hamburger animated fadeInLeft ${isClosed ? 'is-closed' : 'is-open'}`}
                                data-toggle="offcanvas"
                                onClick={handleHamburgerClick}
                            >
                                <span className="hamb-top"></span>
                                <span className="hamb-middle"></span>
                                <span className="hamb-bottom"></span>
                            </button>
                            <div className="container">
                                <div className="row">
                                    <Outlet />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default DoctorDashboard;