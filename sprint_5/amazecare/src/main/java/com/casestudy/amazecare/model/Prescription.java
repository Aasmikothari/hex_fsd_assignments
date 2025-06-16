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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String medicineName;      // e.g., Paracetamol
    private String dosage;            // e.g., 0-0-1
    private String foodInstruction;   // e.g., AF or BF

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}


}