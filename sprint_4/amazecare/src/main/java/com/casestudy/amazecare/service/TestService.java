package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.model.Test;
import com.casestudy.amazecare.repository.PatientRepository;
import com.casestudy.amazecare.repository.TestRepository;

/**
 * Service class for handling business logic related to Medical Tests.
 */
@Service
public class TestService {

    private TestRepository testRepository;
    private PatientRepository patientRepository;

    // Constructor-based dependency injection
    public TestService(TestRepository testRepository, PatientRepository patientRepository) {
        super();
        this.testRepository = testRepository;
        this.patientRepository = patientRepository;
    }

    /**
     * Assign a medical test to a patient.
     * @param patientId ID of the patient
     * @param test Test object with testName and status
     * @return Saved Test object
     * @throws ResourceNotFoundException if patient is not found
     */
    public Test addTestForPatient(int patientId, Test test) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

        test.setPatient(patient);

        // Default to "Pending" if status is not provided
        if (test.getStatus() == null) {
            test.setStatus("Pending");
        }

        return testRepository.save(test);
    }

    /**
     * Get all tests assigned to a patient.
     * @param patientId ID of the patient
     * @return List of tests
     */
    public List<Test> getTestsByPatientId(int patientId) {
        return testRepository.findByPatientId(patientId);
    }

    /**
     * Update a test (e.g., change status, attach report).
     * @param testId ID of the test
     * @param updated Updated test fields
     * @return Updated Test object
     * @throws ResourceNotFoundException if test is not found
     */
    public Test updateTest(int testId, Test updated) {
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new ResourceNotFoundException("Test not found with ID: " + testId));

        test.setTestName(updated.getTestName());
        test.setStatus(updated.getStatus());
        test.setReportPath(updated.getReportPath());

        return testRepository.save(test);
    }

    /**
     * Delete a test by ID.
     * @param testId ID of the test
     * @throws ResourceNotFoundException if test is not found
     */
    public void deleteTest(int testId) {
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new ResourceNotFoundException("Test not found with ID: " + testId));
        testRepository.delete(test);
    }

}
