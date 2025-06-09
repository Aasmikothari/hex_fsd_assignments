package com.coding.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coding.challenge.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	//basic CRUD operations will be performed
}
