package com.coding.challenge1.dto;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge1.model.MedicalHistory;
import com.coding.challenge1.model.Patient;

public class PatientDTO {

    private int id;
    private String name;
    private int age;
    private List<MedicalHistoryDTO> medicalHistories;

    public PatientDTO(int id, String name, int age, List<MedicalHistoryDTO> medicalHistories) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.medicalHistories = medicalHistories;
    }

    // Getters and Setters

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

	public List<MedicalHistoryDTO> getMedicalHistories() {
		return medicalHistories;
	}

	public void setMedicalHistories(List<MedicalHistoryDTO> medicalHistories) {
		this.medicalHistories = medicalHistories;
	}
	
	public static PatientDTO convertPatientToDto(Patient patient, List<MedicalHistory> medicalHistories) {
	    List<MedicalHistoryDTO> historyDTOs = new ArrayList<>();

	    for (MedicalHistory mh : medicalHistories) {
	        historyDTOs.add(new MedicalHistoryDTO(
	                mh.getIllness(),
	                mh.getNumOfYears(),
	                mh.getCurrentMedication()
	        ));
	    }

	    return new PatientDTO(
	            patient.getId(),
	            patient.getName(),
	            patient.getAge(),
	            historyDTOs
	    );
	}
    
}
