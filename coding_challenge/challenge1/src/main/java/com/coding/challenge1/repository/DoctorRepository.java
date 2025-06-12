package com.coding.challenge1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.challenge1.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	Doctor findDoctorById(int doctorId);
	
}
