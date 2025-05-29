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

}
