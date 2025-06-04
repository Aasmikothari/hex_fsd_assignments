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

    // Constructor-based dependency injection
    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              PatientRepository patientRepository) {
        super();
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    /**
     * Book a new appointment between a patient and a doctor.
     * @param patientId ID of the patient booking the appointment
     * @param doctorId ID of the doctor
     * @param appointment Appointment object containing datetime and symptoms
     * @return Saved Appointment object
     * @throws ResourceNotFoundException if patient or doctor is invalid
     */
    public Appointment bookAppointment(int patientId, int doctorId, Appointment appointment) {
        // Validate patient
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

        // Validate doctor
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + doctorId));

        // Attach patient and doctor to appointment
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        // Set default status if not provided
        if (appointment.getStatus() == null) {
            appointment.setStatus("Scheduled");
        }

        // Set datetime if null
        if (appointment.getPreferredDatetime() == null) {
            appointment.setPreferredDatetime(LocalDateTime.now());
        }

        return appointmentRepository.save(appointment);
    }

    /**
     * Get all appointments in the system.
     * @return List of appointments
     */
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    /**
     * Get appointments for a specific doctor.
     * @param doctorId ID of the doctor
     * @return List of appointments
     */
    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    /**
     * Get appointments for a specific patient.
     * @param patientId ID of the patient
     * @return List of appointments
     */
    public List<Appointment> getAppointmentsByPatient(int patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    /**
     * Update appointment status or symptoms.
     * @param appointmentId ID of the appointment to update
     * @param updatedAppointment Appointment object with new fields
     * @return Updated appointment
     * @throws ResourceNotFoundException if appointment is not found
     */
    public Appointment updateAppointment(int appointmentId, Appointment updatedAppointment) {
        Appointment existing = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        existing.setPreferredDatetime(updatedAppointment.getPreferredDatetime());
        existing.setSymptoms(updatedAppointment.getSymptoms());
        existing.setStatus(updatedAppointment.getStatus());

        return appointmentRepository.save(existing);
    }

    /**
     * Cancel or delete an appointment by ID.
     * @param appointmentId ID of the appointment
     * @throws ResourceNotFoundException if appointment is not found
     */
    public void deleteAppointment(int appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));
        appointmentRepository.delete(appointment);
    }

}
