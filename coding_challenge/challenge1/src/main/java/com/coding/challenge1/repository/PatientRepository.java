package com.coding.challenge1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.challenge1.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	Patient findPatientById(int patientId);
	
}
