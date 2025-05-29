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

}
