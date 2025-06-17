package com.casestudy.amazecare.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.model.MedicalRecord;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    // Get doctors by department name
    @Query("SELECT d FROM Doctor d WHERE d.department.name = ?1")
    List<Doctor> findByDepartmentName(String departmentName);

    // Get doctor by username
    @Query("SELECT d FROM Doctor d WHERE d.user.username = ?1")
    Doctor findByUsername(String username);
    
    // Get Doctor by User ID
    @Query("select d from Doctor d where d.user.id=?1")
    Doctor findByUserId(int userId);

    // Find Doctor by Department ID
    @Query("select d from Doctor d where d.department.id=?1")
    List<Doctor> findByDepartmentId(int deptId);
    
    
}