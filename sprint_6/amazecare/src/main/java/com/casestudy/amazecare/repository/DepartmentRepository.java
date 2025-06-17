package com.casestudy.amazecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.casestudy.amazecare.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    // Find Department by Name
    @Query("select d from Department d where d.name=?1")
    Department findByName(String name);
}
