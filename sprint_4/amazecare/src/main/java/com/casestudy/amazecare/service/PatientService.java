package com.casestudy.amazecare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.repository.PatientRepository;

/**
 * Service class for handling business logic related to Patients.
 */
@Service
public class PatientService {

    private PatientRepository patientRepository;

    // Constructor-based dependency injection
    public PatientService(PatientRepository patientRepository) {
        super();
        this.patientRepository = patientRepository;
    }

    /**
     * Registers a new patient in the system.
     * @param patient Patient object with name, email, contact, etc.
     * @return Saved Patient object
     */
    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    /**
     * Get all registered patients from the database.
     * @return List of all patients
     */
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    /**
     * Get a single patient by their ID.
     * @param patientId Patient ID
     * @return Patient object
     * @throws ResourceNotFoundException if patient is not found
     */
    public Patient getPatientById(int patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));
    }

    /**
     * Update an existing patient's details.
     * @param patientId ID of patient to update
     * @param updatedPatient Patient object with updated fields
     * @return Updated Patient object
     * @throws ResourceNotFoundException if patient is not found
     */
    public Patient updatePatient(int patientId, Patient updatedPatient) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

        patient.setName(updatedPatient.getName());
        patient.setEmail(updatedPatient.getEmail());
        patient.setContact(updatedPatient.getContact());
        patient.setGender(updatedPatient.getGender());
        patient.setDob(updatedPatient.getDob());
        patient.setPassword(updatedPatient.getPassword());

        return patientRepository.save(patient);
    }

    /**
     * Delete a patient by ID.
     * @param patientId Patient ID
     * @throws ResourceNotFoundException if patient is not found
     */
    public void deletePatient(int patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));
        patientRepository.delete(patient);
    }

    /**
     * Authenticate a patient using email and password.
     * @param email Patient email
     * @param password Patient password
     * @return Optional Patient (can be empty if not found)
     */
    public Optional<Patient> authenticate(String email, String password) {
        return patientRepository.loginCheckNative(email, password);
    }
}
