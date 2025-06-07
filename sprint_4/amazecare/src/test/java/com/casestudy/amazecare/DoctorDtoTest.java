package com.casestudy.amazecare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.amazecare.model.Department;
import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.model.User;
import com.casestudy.amazecare.repository.DoctorRepository;
import com.casestudy.amazecare.service.DoctorService;

@SpringBootTest
public class DoctorDtoTest {

    @InjectMocks
    private DoctorService doctorService;

    @Mock
    private DoctorRepository doctorRepository;

    private Doctor doctor;
    private Department department;
    private User user;

    @BeforeEach
    public void init() {
        department = new Department();
        department.setId(1);
        department.setName("Cardiology");

        user = new User();
        user.setId(100);
        user.setUsername("dr.aasmi");

        doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("Dr. Aasmi");
        doctor.setContact("9876543210");
        doctor.setEmail("aasmi@amazecare.com");
        doctor.setDepartment(department);
        doctor.setUser(user);

        System.out.println("doctor created at " + doctor);
    }

    @Test
    public void testGetAllDoctors() {
        // Expected result from mocked repository
        when(doctorRepository.findAll()).thenReturn(List.of(doctor));

        // Actual call to the service method
        List<Doctor> doctors = doctorService.getAllDoctors();

        // Assertions
        assertEquals(1, doctors.size());
        assertEquals("Dr. Aasmi", doctors.get(0).getName());
        assertEquals("dr.aasmi", doctors.get(0).getUser().getUsername());
    }

    @AfterEach
    public void cleanup() {
        doctor = null;
        department = null;
        user = null;
        System.out.println("Doctor, Department, and User objects cleared.");
    }
}