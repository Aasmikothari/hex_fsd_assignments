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
     * Get all registered patients from the database.
     * @return List of all patients
     */
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

}