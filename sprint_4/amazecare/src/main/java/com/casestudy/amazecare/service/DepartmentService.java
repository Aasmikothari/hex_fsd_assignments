package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Department;
import com.casestudy.amazecare.repository.DepartmentRepository;

/**
 * Service class for handling business logic related to Departments.
 */
@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
    }
    
    /**
     * Add a new department to the database.
     * @param department The department object containing department name
     * @return The saved Department entity
     */
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    /**
     * Retrieve all departments from the database.
     * @return List of all departments
     */
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    /**
     * Get a department by its ID.
     * @param deptId The ID of the department
     * @return Department object
     * @throws ResourceNotFoundException if the department is not found
     */
    public Department getDepartmentById(int deptId) {
        return departmentRepository.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + deptId));
    }

    /**
     * Delete a department by ID.
     * @param deptId The department's ID
     * @throws ResourceNotFoundException if the department is not found
     */
    public void deleteDepartment(int deptId) {
        Department dept = departmentRepository.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + deptId));
        departmentRepository.delete(dept);
    }

    /**
     * Update an existing department.
     * @param deptId The ID of the department to update
     * @param updatedDept Department object with updated fields
     * @return The updated Department object
     * @throws ResourceNotFoundException if the department is not found
     */
    public Department updateDepartment(int deptId, Department updatedDept) {
        Department dept = departmentRepository.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + deptId));

        dept.setName(updatedDept.getName());

        return departmentRepository.save(dept);
    }

}