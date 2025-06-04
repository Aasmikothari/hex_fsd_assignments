package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.ConsultationRepository;

/**
 * Service class for handling business logic related to Consultations.
 */
@Service
public class ConsultationService {

    private ConsultationRepository consultationRepository;
    private AppointmentRepository appointmentRepository;

    // Constructor-based injection
    public ConsultationService(ConsultationRepository consultationRepository,
                               AppointmentRepository appointmentRepository) {
        super();
        this.consultationRepository = consultationRepository;
        this.appointmentRepository = appointmentRepository;
    }

    /**
     * Add a consultation to a given appointment.
     * @param appointmentId ID of the appointment
     * @param consultation Consultation object with details like symptoms, diagnosis, etc.
     * @return Saved Consultation
     * @throws ResourceNotFoundException if appointment is not found
     */
    public Consultation addConsultation(int appointmentId, Consultation consultation) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        consultation.setAppointment(appointment);
        return consultationRepository.save(consultation);
    }

    /**
     * Get all consultations for a specific appointment.
     * @param appointmentId Appointment ID
     * @return List of consultations
     */
    public List<Consultation> getConsultationsByAppointment(int appointmentId) {
        return consultationRepository.findByAppointmentId(appointmentId);
    }

    /**
     * Update an existing consultation.
     * @param consultationId ID of the consultation
     * @param updated Updated consultation details
     * @return Updated Consultation
     * @throws ResourceNotFoundException if consultation is not found
     */
    public Consultation updateConsultation(int consultationId, Consultation updated) {
        Consultation existing = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new ResourceNotFoundException("Consultation not found with ID: " + consultationId));

        existing.setSymptoms(updated.getSymptoms());
        existing.setPhysicalDetails(updated.getPhysicalDetails());
        existing.setDiagnosis(updated.getDiagnosis());
        existing.setRecommendedTests(updated.getRecommendedTests());

        return consultationRepository.save(existing);
    }

    /**
     * Delete a consultation by ID.
     * @param consultationId ID of consultation
     * @throws ResourceNotFoundException if consultation not found
     */
    public void deleteConsultation(int consultationId) {
        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new ResourceNotFoundException("Consultation not found with ID: " + consultationId));
        consultationRepository.delete(consultation);
    }
}
