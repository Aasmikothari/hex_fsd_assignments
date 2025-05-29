package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Department;
import com.casestudy.amazecare.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	/*
	 * # AIM    : Add a new department (e.g., Cardiology, Neurology)
	 * # PATH   : /api/department
	 * # METHOD : POST
	 * # BODY   : { "name": "Cardiology" }
	 * # RETURN : Department
	 */
	@PostMapping("/api/department")
	public Department addDepartment(@RequestBody Department dept) {
		return departmentService.addDepartment(dept);
	}

	/*
	 * # AIM    : Get all departments
	 * # PATH   : /api/department
	 * # METHOD : GET
	 * # RETURN : List<Department>
	 */
	@GetMapping("/api/department")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	/*
	 * # AIM    : Get department by ID
	 * # PATH   : /api/department/{id}
	 * # METHOD : GET
	 * # PARAM  : Path Variable (id)
	 * # RETURN : Department
	 */
	@GetMapping("/api/department/{id}")
	public Department getDepartmentById(@PathVariable int id) {
		return departmentService.getDepartmentById(id);
	}

	/*
	 * # AIM    : Update department by ID
	 * # PATH   : /api/department/{id}
	 * # METHOD : PUT
	 * # PARAM  : Path Variable (id), Request Body { "name": "New Name" }
	 * # RETURN : Department
	 */
	@PutMapping("/api/department/{id}")
	public Department updateDepartment(@PathVariable int id, @RequestBody Department updated) {
		return departmentService.updateDepartment(id, updated);
	}

	/*
	 * # AIM    : Delete department by ID
	 * # PATH   : /api/department/{id}
	 * # METHOD : DELETE
	 * # PARAM  : Path Variable (id)
	 * # RETURN : String message
	 */
	@DeleteMapping("/api/department/{id}")
	public String deleteDepartment(@PathVariable int id) {
		departmentService.deleteDepartment(id);
		return "Department deleted successfully";
	}

}
