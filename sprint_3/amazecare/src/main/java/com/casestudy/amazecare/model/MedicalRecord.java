package com.casestudy.amazecare.model;

import jakarta.persistence.*;

/**
 * This class represents a Medical Record in the AmazeCare system.
 * It serves as a summary record tied to a specific appointment and consultation,
 * and optionally links to a prescription.
 */

@Entity
@Table(name = "medical_record")
public class MedicalRecord {

    // Primary key for the medical_record table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Link to the appointment this record is associated with
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    // Link to the consultation held during the appointment
    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    // Optional link to the prescription issued (can be null if no meds)
    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    private String diagnosisSummary;
    private String notes;
    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public String getDiagnosisSummary() {
        return diagnosisSummary;
    }

    public void setDiagnosisSummary(String diagnosisSummary) {
        this.diagnosisSummary = diagnosisSummary;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}