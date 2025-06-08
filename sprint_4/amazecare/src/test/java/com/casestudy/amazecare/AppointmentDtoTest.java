package com.casestudy.amazecare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.DoctorRepository;
import com.casestudy.amazecare.repository.PatientRepository;
import com.casestudy.amazecare.service.AppointmentService;

@SpringBootTest
public class AppointmentDtoTest {

    @InjectMocks
    private AppointmentService appointmentService;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private PatientRepository patientRepository;

    private Appointment appointment;
    private Doctor doctor;
    private Patient patient;

    @BeforeEach
    public void init() {
        doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("Dr. Strange");

        patient = new Patient();
        patient.setId(1);
        patient.setName("Tony Stark");

        appointment = new Appointment();
        appointment.setId(100);
        appointment.setSymptoms("Headache and dizziness");
        // Intentionally not setting status or datetime to test service logic
    }

    @Test
    public void testBookAppointmentSuccess() {
        // Arrange (mock the DB return values)
        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));
        when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));

        // Inject patient & doctor to appointment manually to mock what service does
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setStatus("Scheduled");
        appointment.setPreferredDatetime(LocalDateTime.now());

        when(appointmentRepository.save(appointment)).thenReturn(appointment);

        // Act
        Appointment result = appointmentService.bookAppointment(1, 1, appointment);

        // Assert
        assertEquals("Scheduled", result.getStatus());
        assertEquals("Tony Stark", result.getPatient().getName());
        assertEquals("Dr. Strange", result.getDoctor().getName());
        assertEquals("Headache and dizziness", result.getSymptoms());
    }

    @Test
    public void testBookAppointmentInvalidPatient() {
        when(patientRepository.findById(999)).thenReturn(Optional.empty());

        ResourceNotFoundException ex = org.junit.jupiter.api.Assertions.assertThrows(
            ResourceNotFoundException.class,
            () -> appointmentService.bookAppointment(999, 1, appointment)
        );

        assertEquals("Patient not found with ID: 999", ex.getMessage());
    }

    @Test
    public void testBookAppointmentInvalidDoctor() {
        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));
        when(doctorRepository.findById(999)).thenReturn(Optional.empty());

        ResourceNotFoundException ex = org.junit.jupiter.api.Assertions.assertThrows(
            ResourceNotFoundException.class,
            () -> appointmentService.bookAppointment(1, 999, appointment)
        );

        assertEquals("Doctor not found with ID: 999", ex.getMessage());
    }

    @AfterEach
    public void cleanup() {
        appointment = null;
        doctor = null;
        patient = null;
        System.out.println("Appointment test objects cleared from memory.");
    }
}
