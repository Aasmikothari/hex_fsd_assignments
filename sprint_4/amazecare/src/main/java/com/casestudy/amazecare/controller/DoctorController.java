package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	/*
	 * # AIM    : Get all doctors
	 * # PATH   : /api/doctor
	 * # METHOD : GET
	 * # RETURN : List<Doctor>
	 */
	@GetMapping("/api/doctor")
	public List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}
	
	/*
	 * # AIM    : Add new doctor under a department
	 * # PATH   : /api/doctor/{deptId}
	 * # METHOD : POST
	 * # PARAM  : Path Variable (deptId), Request Body (Doctor)
	 * # RETURN : Doctor
	 */
	@PostMapping("/api/doctor/{deptId}")
	public Doctor addDoctor(@PathVariable int deptId, @RequestBody Doctor doctor) {
		return doctorService.addDoctor(deptId, doctor);
	}

	/*
	 * # AIM    : Get all doctors by department ID
	 * # PATH   : /api/doctor/department/{deptId}
	 * # METHOD : GET
	 * # PARAM  : Path Variable (deptId)
	 * # RETURN : List<Doctor>
	 */
	@GetMapping("/api/doctor/department/{deptId}")
	public List<Doctor> getDoctorsByDepartment(@PathVariable int deptId) {
		return doctorService.getDoctorsByDepartmentId(deptId);
	}

	/*
	 * # AIM    : Get doctor by ID
	 * # PATH   : /api/doctor/{id}
	 * # METHOD : GET
	 * # PARAM  : Path Variable (id)
	 * # RETURN : Doctor
	 */
	@GetMapping("/api/doctor/{id}")
	public Doctor getDoctorById(@PathVariable int id) {
		return doctorService.getDoctorById(id);
	}

	/*
	 * # AIM    : Update doctor by ID
	 * # PATH   : /api/doctor/{id}
	 * # METHOD : PUT
	 * # PARAM  : Path Variable (id), Request Body (Doctor)
	 * # RETURN : Updated Doctor
	 */
	@PutMapping("/api/doctor/{id}")
	public Doctor updateDoctor(@PathVariable int id, @RequestBody Doctor updated) {
		return doctorService.updateDoctor(id, updated);
	}

	/*
	 * # AIM    : Delete doctor by ID
	 * # PATH   : /api/doctor/{id}
	 * # METHOD : DELETE
	 * # PARAM  : Path Variable (id)
	 * # RETURN : String
	 */
	@DeleteMapping("/api/doctor/{id}")
	public String deleteDoctor(@PathVariable int id) {
		doctorService.deleteDoctor(id);
		return "Doctor deleted successfully";
	}


}
