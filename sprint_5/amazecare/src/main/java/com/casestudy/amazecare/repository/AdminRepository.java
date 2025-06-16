package com.casestudy.amazecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.casestudy.amazecare.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    // Get Admin by User ID
    @Query("select a from Admin a where a.user.id=?1")
    Admin findByUserId(int userId);
    
 // Get doctor by username
    @Query("SELECT a FROM Admin a WHERE a.user.username = ?1")
    Admin findByUsername(String username);
}