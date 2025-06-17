package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Prescription;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.PrescriptionRepository;

@Service
public class PrescriptionService {

    private PrescriptionRepository prescriptionRepository;
    private AppointmentRepository appointmentRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository,
                               AppointmentRepository appointmentRepository) {
        super();
        this.prescriptionRepository = prescriptionRepository;
        this.appointmentRepository = appointmentRepository;
    }

    // Get prescriptions by appointment ID
    public List<Prescription> getPrescriptionsByAppointmentId(int appointmentId) {
        return prescriptionRepository.findByAppointmentId(appointmentId);
    }

    // Add a new prescription for an appointment
    public Prescription addPrescription(int appointmentId, Prescription prescription) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        prescription.setAppointment(appointment);
        return prescriptionRepository.save(prescription);
    }
}