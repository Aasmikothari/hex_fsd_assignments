package com.coding.challenge1.dto;

public class MedicalHistoryDTO {
    private String illness;
    private int numOfYears;
    private String currentMedication;

    // Constructor
    public MedicalHistoryDTO(String illness, int numOfYears, String currentMedication) {
        this.illness = illness;
        this.numOfYears = numOfYears;
        this.currentMedication = currentMedication;
    }

    // Getters
    public String getIllness() {
        return illness;
    }

    public int getNumOfYears() {
        return numOfYears;
    }

    public String getCurrentMedication() {
        return currentMedication;
    }
}
