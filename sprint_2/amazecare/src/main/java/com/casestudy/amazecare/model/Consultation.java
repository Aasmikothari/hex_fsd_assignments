package com.casestudy.amazecare.model;

import jakarta.persistence.*;

/**
 * This class represents a Consultation during an appointment in the AmazeCare system.
 * Each consultation is linked to one appointment.
 * It captures diagnosis details, symptoms, and physical examination observations.
 */

@Entity
@Table(name = "consultation")
public class Consultation {

    // Primary key for the consultation table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Link to the appointment this consultation belongs to
    @ManyToOne
    @JoinColumn(name = "appointment_id")  // foreign key column
    private Appointment appointment;

    private String symptoms;
    private String physicalDetails;
    private String diagnosis;
    private String recommendedTests;

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

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPhysicalDetails() {
        return physicalDetails;
    }

    public void setPhysicalDetails(String physicalDetails) {
        this.physicalDetails = physicalDetails;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRecommendedTests() {
        return recommendedTests;
    }

    public void setRecommendedTests(String recommendedTests) {
        this.recommendedTests = recommendedTests;
    }

}
