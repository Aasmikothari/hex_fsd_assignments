package com.casestudy.amazecare.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.DoctorRepository;
import com.casestudy.amazecare.repository.PatientRepository;

/**
 * Service class for handling business logic related to Appointments.
 */
@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              PatientRepository patientRepository) {
        super();
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

}
