package com.casestudy.amazecare.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * This class represents an Appointment in the AmazeCare system.
 * Each appointment is booked by one patient and is assigned to one doctor.
 */

@Entity
@Table(name = "appointment")
public class Appointment {

    // Primary key for the appointment table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // The patient who booked the appointment
    @ManyToOne
    @JoinColumn(name = "patient_id")  // foreign key column to patient table
    private Patient patient;

    // The doctor assigned to this appointment
    @ManyToOne
    @JoinColumn(name = "doctor_id")   // foreign key column to doctor table
    private Doctor doctor;

    private LocalDateTime preferredDatetime;
    private String symptoms;
    private String status;

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getPreferredDatetime() {
        return preferredDatetime;
    }

    public void setPreferredDatetime(LocalDateTime preferredDatetime) {
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

}
