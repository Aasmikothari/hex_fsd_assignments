package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        super();
        this.appointmentRepository = appointmentRepository;
    }

    // Get appointment by ID
    public Appointment getAppointmentById(int appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));
    }

    // Reschedule an appointment
    public Appointment rescheduleAppointment(int appointmentId, String newDate, String newTime) {
        Appointment existingAppointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        existingAppointment.setAppointmentDate(newDate);
        existingAppointment.setAppointmentTime(newTime);
        existingAppointment.setStatus("RESCHEDULED");

        return appointmentRepository.save(existingAppointment);
    }

    // Cancel an appointment
    public Appointment cancelAppointment(int appointmentId) {
        Appointment existingAppointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        existingAppointment.setStatus("CANCELLED");
        return appointmentRepository.save(existingAppointment);
    }

    // Get all appointments by status
    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentRepository.findByStatus(status);
    }

    // Get all appointments of a doctor
    public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    // Get all appointments of a patient
    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}