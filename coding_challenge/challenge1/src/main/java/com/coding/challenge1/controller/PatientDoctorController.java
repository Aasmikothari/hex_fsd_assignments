package com.coding.challenge1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.challenge1.model.Patient;
import com.coding.challenge1.model.PatientDoctor;
import com.coding.challenge1.model.Speciality;
import com.coding.challenge1.service.PatientDoctorService;

@RestController
@RequestMapping("/api/patientdoctor")
public class PatientDoctorController {
	
	@Autowired
	private PatientDoctorService pdService;
	
	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<List<Patient>> getPatientByDoctorId(@PathVariable int doctorId){
		List<Patient> get = pdService.getPatientByDoctorId(doctorId);
		return ResponseEntity.status(HttpStatus.OK).body(get);
	}
	
	@PostMapping("/appointment/{patientId}/{doctorId}")
	public ResponseEntity<PatientDoctor> addPatientWithDoctorId(@PathVariable int patientId, @PathVariable int doctorId){
		PatientDoctor add = pdService.addPatientWithDoctorId(patientId, doctorId);
		return ResponseEntity.status(HttpStatus.CREATED).body(add);
	}
	
	@GetMapping("/Speciality")
	public ResponseEntity<List<Patient>> getPatientByDoctorSpeciality(@PathVariable Speciality speciality){
		List<Patient> get = pdService.getPatientByDoctorSpeciality(speciality);
		return ResponseEntity.status(HttpStatus.OK).body(get);
	}
}
