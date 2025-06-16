package com.casestudy.amazecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.casestudy.amazecare.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // Get patient by username
    @Query("SELECT p FROM Patient p WHERE p.user.username = ?1")
    Patient findByUsername(String username);
    
    // Get Patient by User ID
    @Query("select p from Patient p where p.user.id=?1")
    Patient findByUserId(int userId);
}