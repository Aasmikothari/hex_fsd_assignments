package com.casestudy.amazecare.model;

import jakarta.persistence.*;

/**
 * This class represents a medical Test recommended to a patient.
 * Each test is linked to a specific patient.
 */

@Entity
@Table(name = "test")
public class Test {

    // Primary key for the test table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String testName;
    private String status;
    private String reportPath;

    // Patient who is assigned this test
    @ManyToOne
    @JoinColumn(name = "patient_id")  // foreign key to patient table
    private Patient patient;

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}