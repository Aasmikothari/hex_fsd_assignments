package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.model.Prescription;
import com.casestudy.amazecare.repository.ConsultationRepository;
import com.casestudy.amazecare.repository.PrescriptionRepository;

/**
 * Service class for handling business logic related to Prescriptions.
 */
@Service
public class PrescriptionService {

    private PrescriptionRepository prescriptionRepository;
    private ConsultationRepository consultationRepository;

    // Constructor-based dependency injection
    public PrescriptionService(PrescriptionRepository prescriptionRepository,
                               ConsultationRepository consultationRepository) {
        super();
        this.prescriptionRepository = prescriptionRepository;
        this.consultationRepository = consultationRepository;
    }

    /**
     * Add a new prescription for a consultation.
     * @param consultationId ID of the consultation
     * @param prescription Prescription object with medicine details
     * @return Saved Prescription object
     * @throws ResourceNotFoundException if consultation is not found
     */
    public Prescription addPrescription(int consultationId, Prescription prescription) {
        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new ResourceNotFoundException("Consultation not found with ID: " + consultationId));

        prescription.setConsultation(consultation);
        return prescriptionRepository.save(prescription);
    }

    /**
     * Get all prescriptions for a consultation.
     * @param consultationId ID of the consultation
     * @return List of prescriptions
     */
    public List<Prescription> getPrescriptionsByConsultation(int consultationId) {
        return prescriptionRepository.findByConsultationId(consultationId);
    }

    /**
     * Update an existing prescription.
     * @param prescriptionId ID of the prescription
     * @param updated Updated prescription object
     * @return Updated Prescription
     * @throws ResourceNotFoundException if prescription is not found
     */
    public Prescription updatePrescription(int prescriptionId, Prescription updated) {
        Prescription existing = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found with ID: " + prescriptionId));

        existing.setMedicineName(updated.getMedicineName());
        existing.setDosage(updated.getDosage());
        existing.setFoodInstruction(updated.getFoodInstruction());
        existing.setNotes(updated.getNotes());

        return prescriptionRepository.save(existing);
    }

    /**
     * Delete a prescription by ID.
     * @param prescriptionId Prescription ID
     * @throws ResourceNotFoundException if not found
     */
    public void deletePrescription(int prescriptionId) {
        Prescription prescription = prescriptionRepository.findById(prescriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found with ID: " + prescriptionId));
        prescriptionRepository.delete(prescription);
    }
}
