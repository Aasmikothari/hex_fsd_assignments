package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.model.Department;
import com.casestudy.amazecare.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
    }

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    
    // Add departments
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

}