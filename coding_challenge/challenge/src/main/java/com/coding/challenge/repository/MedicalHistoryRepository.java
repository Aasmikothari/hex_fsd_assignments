package com.coding.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coding.challenge.dto.MedicalHistoryDTO;
import com.coding.challenge.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer> {

	// Api-4 : Get all medical histories by patient ID
	// We want to get all details except for the MedicalHistory ID
	
	@Query("SELECT new com.coding.challenge.dto.MedicalHistoryDTO(m.illness, m.numOfYears, m.currentMedication) " +
	           "FROM MedicalHistory m WHERE m.patient.id = :patientId")
	List<MedicalHistoryDTO> findHistoryByPatientId(int patientId);
}
