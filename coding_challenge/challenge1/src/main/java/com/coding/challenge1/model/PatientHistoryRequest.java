package com.coding.challenge1.model;

import java.util.Set;

public class PatientHistoryRequest {
	
    private Patient patient;
    private User user;
    private Set<MedicalHistory> medicalHistories;
    
    
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<MedicalHistory> getMedicalHistories() {
		return medicalHistories;
	}
	public void setMedicalHistories(Set<MedicalHistory> medicalHistories) {
		this.medicalHistories = medicalHistories;
	}
}
