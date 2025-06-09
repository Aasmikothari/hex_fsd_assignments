package com.coding.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coding.challenge.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	// Api-3 : Get all patients treated by a particular doctor
	// Will let us get all the patients for the doctor
	List<Patient> findByDoctorsId(int doctorId);
}
