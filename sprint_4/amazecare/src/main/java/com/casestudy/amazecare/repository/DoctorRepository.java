package com.casestudy.amazecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.casestudy.amazecare.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    // Get all doctors in a given department using JPQL
    @Query("SELECT d FROM Doctor d WHERE d.department.id = ?1")
    List<Doctor> findByDepartmentId(int deptId);
}
