package com.casestudy.amazecare.model;

import jakarta.persistence.*;

/**
 * This class represents a Prescription issued during a consultation.
 * A prescription is linked to one consultation.
 * It contains medicine names, dosage instructions, and timing.
 */

@Entity
@Table(name = "prescription")
public class Prescription {

    // Primary key for the prescription table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Link to the consultation this prescription belongs to
    @ManyToOne
    @JoinColumn(name = "consultation_id")  // foreign key column
    private Consultation consultation;

    private String medicineName;
    private String dosage;
    private String foodInstruction;
    private String notes;

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFoodInstruction() {
        return foodInstruction;
    }

    public void setFoodInstruction(String foodInstruction) {
        this.foodInstruction = foodInstruction;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}