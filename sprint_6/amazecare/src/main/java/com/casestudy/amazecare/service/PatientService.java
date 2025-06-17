package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.MedicalRecord;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.MedicalRecordRepository;
import com.casestudy.amazecare.repository.PatientRepository;

@Service
public class PatientService {

    private PatientRepository patientRepository;
    private AppointmentRepository appointmentRepository;
    private MedicalRecordRepository medicalRecordRepository;

    public PatientService(PatientRepository patientRepository,
                          AppointmentRepository appointmentRepository,
                          MedicalRecordRepository medicalRecordRepository) {
        super();
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    // Get patient by user ID (for profile or login purpose)
    public Patient getPatientByUserId(int userId) {
        return patientRepository.findByUserId(userId);
    }

    // Book a new appointment
    public Appointment bookAppointment(Appointment appointment, int patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

        appointment.setPatient(patient);
        appointment.setStatus("PENDING"); // default status
        return appointmentRepository.save(appointment);
    }

    // Cancel an appointment by appointment ID
    public Appointment cancelAppointment(int appointmentId) {
        Appointment existingAppointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        existingAppointment.setStatus("CANCELLED");
        return appointmentRepository.save(existingAppointment);
    }

    // Get all appointments of patient by status
    public List<Appointment> getAppointmentsByPatientAndStatus(int patientId, String status) {
        List<Appointment> allAppointments = appointmentRepository.findByPatientId(patientId);
        return allAppointments.stream()
                .filter(a -> a.getStatus().equalsIgnoreCase(status))
                .toList();
    }

    // View medical records by patient ID
    public List<MedicalRecord> getMedicalRecordsByPatientId(int patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }
}