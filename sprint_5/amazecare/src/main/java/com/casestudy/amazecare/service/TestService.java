package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Test;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.TestRepository;

@Service
public class TestService {

    private TestRepository testRepository;
    private AppointmentRepository appointmentRepository;

    public TestService(TestRepository testRepository,
                       AppointmentRepository appointmentRepository) {
        super();
        this.testRepository = testRepository;
        this.appointmentRepository = appointmentRepository;
    }

    // Get all tests by appointment ID
    public List<Test> getTestsByAppointmentId(int appointmentId) {
        return testRepository.findByAppointmentId(appointmentId);
    }

    // Get tests by status
    public List<Test> getTestsByStatus(String status) {
        return testRepository.findByStatus(status);
    }

    // Update result and status of a test
    public Test updateTestResult(int testId, String result, String status) {
        Test existingTest = testRepository.findById(testId)
                .orElseThrow(() -> new ResourceNotFoundException("Test not found with ID: " + testId));

        existingTest.setResult(result);
        existingTest.setStatus(status);

        return testRepository.save(existingTest);
    }

    // Add a new test for an appointment
    public Test addTest(int appointmentId, Test test) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        test.setAppointment(appointment);
        return testRepository.save(test);
    }
}