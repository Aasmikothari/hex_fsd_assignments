package com.casestudy.amazecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.casestudy.amazecare.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
