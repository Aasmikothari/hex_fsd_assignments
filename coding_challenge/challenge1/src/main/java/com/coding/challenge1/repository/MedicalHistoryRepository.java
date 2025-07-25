package com.coding.challenge1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.challenge1.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer> {
	
	List<MedicalHistory> findByPatientId(int patientId);

}
