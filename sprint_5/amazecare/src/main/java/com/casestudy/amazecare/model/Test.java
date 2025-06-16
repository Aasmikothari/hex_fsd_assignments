package com.casestudy.amazecare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String testName;    // e.g., "Blood Test", "X-Ray"
    private String result;      // e.g., "Normal", "Elevated", optional
    private String status;      // e.g., "Pending", "Completed", optional

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
    
    
}
