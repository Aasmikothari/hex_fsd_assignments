package com.coding.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.coding.challenge.exception.ResourceNotFoundException;
import com.coding.challenge.model.Doctor;
import com.coding.challenge.model.Patient;
import com.coding.challenge.repository.DoctorRepository;
import com.coding.challenge.service.DoctorService;

@SpringBootTest
public class PatientDtoTest {

    @InjectMocks
    private DoctorService doctorService;

    @Mock
    private DoctorRepository doctorRepository;

    private Doctor doctor;
    private Patient patient1;
    private Patient patient2;

    @BeforeEach
    public void init() {
        doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("Dr. Aasmi");

        patient1 = new Patient();
        patient1.setId(101);
        patient1.setName("Alice");
        patient1.setAge(30);

        patient2 = new Patient();
        patient2.setId(102);
        patient2.setName("Bob");
        patient2.setAge(45);

        doctor.setPatients(new HashSet<>(Arrays.asList(patient1, patient2)));

        System.out.println("Doctor and patients initialized.");
    }

    @Test
    public void testGetPatientsByDoctorId() {
        when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));

        List<Patient> patients = doctorService.getPatientsByDoctorId(1);

        // Assertions
        assertEquals(2, patients.size());
        assertEquals("Alice", patients.get(0).getName());
        assertEquals(30, patients.get(0).getAge());
        assertEquals("Bob", patients.get(1).getName());
        assertEquals(45, patients.get(1).getAge());
    }

    @Test
    public void testDoctorNotFound() {
        when(doctorRepository.findById(999)).thenReturn(Optional.empty());

        try {
            doctorService.getPatientsByDoctorId(999);
        } catch (ResourceNotFoundException e) {
            assertEquals("Doctor not found with ID: 999", e.getMessage());
        }
    }

    @AfterEach
    public void cleanup() {
        doctor = null;
        patient1 = null;
        patient2 = null;
        System.out.println("Doctor and Patient objects cleared.");
    }
}