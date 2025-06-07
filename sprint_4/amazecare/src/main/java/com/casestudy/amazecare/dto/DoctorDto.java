package com.casestudy.amazecare.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.casestudy.amazecare.model.Doctor;

@Component
public class DoctorDto {

    private int id;
    private String name;
    private String username;
    private String departmentName;

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // Conversion method: List<Doctor> → List<DoctorDto>
    public List<DoctorDto> convertDoctorToDto(List<Doctor> list) {
        List<DoctorDto> listDto = new ArrayList<>();

        list.stream().forEach(doc -> {
            DoctorDto dto = new DoctorDto();
            dto.setId(doc.getId());
            dto.setName(doc.getName());
            dto.setUsername(doc.getUser().getUsername());
            dto.setDepartmentName(doc.getDepartment().getName());
            listDto.add(dto);
        });

        return listDto;
    }
}
