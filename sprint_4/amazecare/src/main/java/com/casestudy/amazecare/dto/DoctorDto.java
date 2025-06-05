package com.casestudy.amazecare.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.casestudy.amazecare.model.Doctor;

/**
 * DoctorDto exposes selected fields from the Doctor entity,
 * including the associated User's username.
 */
@Component
public class DoctorDto {

    private int id;
    private String name;
    private String username;

    // === Getters and Setters ===

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Converts a list of Doctor entities into a list of DoctorDto objects.
     * Only id, name, and linked user's username are included.
     */
    public List<DoctorDto> convertDoctorListToDto(List<Doctor> doctorList) {
        List<DoctorDto> dtoList = new ArrayList<>();

        doctorList.forEach(doctor -> {
            DoctorDto dto = new DoctorDto();
            dto.setId(doctor.getId());
            dto.setName(doctor.getName());

            // ✅ LMS-style: extract username from linked User
            if (doctor.getUser() != null) {
                dto.setUsername(doctor.getUser().getUsername());
            } else {
                dto.setUsername("N/A"); // Optional: fallback
            }

            dtoList.add(dto);
        });

        return dtoList;
    }
}