package com.casestudy.amazecare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.model.User;
import com.casestudy.amazecare.repository.PatientRepository;
import com.casestudy.amazecare.service.PatientService;

@SpringBootTest
public class PatientDtoTest {

    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;

    private Patient patient;
    private User user;

    @BeforeEach
    public void init() {
        user = new User();
        user.setId(101);
        user.setUsername("john_doe");

        patient = new Patient();
        patient.setId(1);
        patient.setName("John Doe");
        patient.setGender("Male");
        patient.setContact("9876543210");
        patient.setUser(user);

        System.out.println("Patient object created at: " + patient);
    }

    @Test
    public void testGetPatientById() {
        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));

        Patient fetched = patientService.getPatientById(1);

        assertEquals("John Doe", fetched.getName());
        assertEquals("john_doe", fetched.getUser().getUsername());
    }

    @Test
    public void testGetPatientByInvalidId() {
        when(patientRepository.findById(99)).thenReturn(Optional.empty());

        ResourceNotFoundException ex = org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class,
            () -> patientService.getPatientById(99));

        assertEquals("Patient ID Invalid".toLowerCase(), ex.getMessage().toLowerCase());
    }

    @AfterEach
    public void cleanup() {
        patient = null;
        user = null;
        System.out.println("Test data cleaned.");
    }
}