package com.casestudy.amazecare.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.casestudy.amazecare.model.Appointment;

@Component
public class AppointmentDto {

    private int id;
    private String patientName;
    private String doctorName;
    private String preferredDatetime;
    private String symptoms;
    private String status;

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPreferredDatetime() {
        return preferredDatetime;
    }

    public void setPreferredDatetime(String preferredDatetime) {
        this.preferredDatetime = preferredDatetime;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*
     * AIM: Convert List<Appointment> to List<AppointmentDto>
     * USAGE: Frontend-friendly format with only relevant details
     */
    public List<AppointmentDto> convertAppointmentsToDto(List<Appointment> appointments) {
        List<AppointmentDto> dtoList = new ArrayList<>();
        appointments.forEach(app -> {
            AppointmentDto dto = new AppointmentDto();
            dto.setId(app.getId());
            dto.setPatientName(app.getPatient().getName());
            dto.setDoctorName(app.getDoctor().getName());
            dto.setPreferredDatetime(app.getPreferredDatetime().toString());
            dto.setSymptoms(app.getSymptoms());
            dto.setStatus(app.getStatus());
            dtoList.add(dto);
        });
        return dtoList;
    }
}