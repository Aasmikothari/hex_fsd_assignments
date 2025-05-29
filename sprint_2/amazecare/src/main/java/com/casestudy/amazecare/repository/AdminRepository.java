package com.casestudy.amazecare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.casestudy.amazecare.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    // Find admin by email
    Optional<Admin> findByEmail(String email);
}