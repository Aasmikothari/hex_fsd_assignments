package com.casestudy.amazecare;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.casestudy.amazecare.dto.DoctorDto;
import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.model.User;

public class DoctorDtoTest {

    private Doctor doctor;
    private DoctorDto doctorDto;

    @BeforeEach // <-- Runs before every test
    public void init() {
        // Create a User object
        User user = new User();
        user.setId(101);
        user.setUsername("drjones");
        user.setPassword("securepass");
        user.setRole("DOCTOR");

        // Create a Doctor object and link with User
        doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("Dr. Indiana Jones");
        doctor.setEmail("dr.jones@example.com");
        doctor.setContact("9876543210");
        doctor.setQualification("MBBS, MS");
        doctor.setDesignation("Cardiologist");
        doctor.setExperience(12);
        doctor.setUser(user);

        // Instantiate DoctorDto
        doctorDto = new DoctorDto();

        System.out.println("Doctor created at: " + doctor);
    }

    @Test
    public void convertDoctorListToDtoTest() {
        // Create a list of Doctor
        List<Doctor> doctorList = List.of(doctor);

        // Convert to DTO list
        List<DoctorDto> dtoList = doctorDto.convertDoctorListToDto(doctorList);

        // Assertions
        assertEquals(1, dtoList.size());

        DoctorDto dto = dtoList.get(0);

        assertEquals(doctor.getId(), dto.getId());
        assertEquals(doctor.getName(), dto.getName());
        assertEquals(doctor.getUser().getUsername(), dto.getUsername());
    }
    

    @AfterEach // <-- Cleanup after each test
    public void afterTest() {
        doctor = null;
        doctorDto = null;
        System.out.println("Doctor object released..");
    }
}
