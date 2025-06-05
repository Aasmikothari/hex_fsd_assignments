package com.casestudy.amazecare.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;


	/*
	 * # AIM    : Get all patients
	 * # PATH   : /api/patient
	 * # METHOD : GET
	 * # RETURN : List<Patient>
	 */
	@GetMapping("/api/patient")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}
	
	/*
	 * # AIM    : Register a new patient
	 * # PATH   : /api/patient
	 * # METHOD : POST
	 * # BODY   : Patient object
	 * # RETURN : Patient
	 */
	@PostMapping("/api/patient")
	public Patient registerPatient(@RequestBody Patient patient) {
		return patientService.registerPatient(patient);
	}
	
	/*
	 * # AIM    : Get patient by ID
	 * # PATH   : /api/patient/{id}
	 * # METHOD : GET
	 * # PARAM  : Path Variable (id)
	 * # RETURN : Patient
	 */
	@GetMapping("/api/patient/{id}")
	public Patient getPatientById(@PathVariable int id) {
		return patientService.getPatientById(id);
	}

	/*
	 * # AIM    : Update patient by ID
	 * # PATH   : /api/patient/{id}
	 * # METHOD : PUT
	 * # PARAM  : Path Variable (id), Request Body (Patient)
	 * # RETURN : Updated Patient
	 */
	@PutMapping("/api/patient/{id}")
	public Patient updatePatient(@PathVariable int id, @RequestBody Patient updated) {
		return patientService.updatePatient(id, updated);
	}

	/*
	 * # AIM    : Delete patient by ID
	 * # PATH   : /api/patient/{id}
	 * # METHOD : DELETE
	 * # PARAM  : Path Variable (id)
	 * # RETURN : String
	 */
	@DeleteMapping("/api/patient/{id}")
	public String deletePatient(@PathVariable int id) {
		patientService.deletePatient(id);
		return "Patient deleted successfully";
	}

	/*
	 * # AIM    : Authenticate patient using email & password
	 * # PATH   : /api/patient/login/{email}/{password}
	 * # METHOD : GET
	 * # RETURN : Optional<Patient>
	 */
	@GetMapping("/api/patient/login/{email}/{password}")
	public Optional<Patient> loginPatient(@PathVariable String email, @PathVariable String password) {
		return patientService.authenticate(email, password);
	}

}
