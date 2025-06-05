package com.casestudy.amazecare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.casestudy.amazecare.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // Find patient by email
    Optional<Patient> findByEmail(String email);

    // Optional native query (example)
    @Query(value = "SELECT * FROM patient WHERE email=?1 AND password=?2", nativeQuery = true)
    Optional<Patient> loginCheckNative(String email, String password);
}
