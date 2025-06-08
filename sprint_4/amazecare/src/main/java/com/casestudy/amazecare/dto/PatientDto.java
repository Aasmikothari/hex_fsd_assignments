package com.casestudy.amazecare.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.casestudy.amazecare.model.Patient;

@Component
public class PatientDto {

    private int id;
    private String name;
    private String username;

    // Getters & Setters

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

    /*
     * AIM: Convert List<Patient> to List<PatientDto>
     * REASON: To only send limited, readable info to the frontend
     */
    public List<PatientDto> convertPatientListToDto(List<Patient> patientList) {
        List<PatientDto> dtoList = new ArrayList<>();
        patientList.forEach(patient -> {
            PatientDto dto = new PatientDto();
            dto.setId(patient.getId());
            dto.setName(patient.getName());
            dto.setUsername(patient.getUser().getUsername());
            dtoList.add(dto);
        });
        return dtoList;
    }
}
