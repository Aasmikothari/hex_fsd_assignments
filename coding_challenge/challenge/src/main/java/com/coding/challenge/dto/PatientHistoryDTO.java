package com.coding.challenge.dto;

import java.util.Set;
import com.coding.challenge.model.MedicalHistory;
import com.coding.challenge.model.Patient;
import com.coding.challenge.model.User;

public class PatientHistoryDTO {

    private Patient patient;
    private Set<MedicalHistory> medicalHistories;
    private User user;

    // Getters and Setters

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<MedicalHistory> getMedicalHistories() {
        return medicalHistories;
    }

    public void setMedicalHistories(Set<MedicalHistory> medicalHistories) {
        this.medicalHistories = medicalHistories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
