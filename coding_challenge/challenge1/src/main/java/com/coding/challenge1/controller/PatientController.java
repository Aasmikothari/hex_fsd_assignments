package com.coding.challenge1.controller;

import com.coding.challenge1.dto.PatientDTO;
import com.coding.challenge1.model.Patient;
import com.coding.challenge1.model.PatientHistoryRequest;
import com.coding.challenge1.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    

    /*
     * AIM   : Add a new patient with user and medical history details.
     * PATH  : /api/patient/add
     * METHOD: POST
     * ROLE  : PERMIT ALL
     * RETURN: Saved patient object

    *@PostMapping("/add")
    *public ResponseEntity<Patient> addPatientWithUser (@RequestBody Patient patient){
    *	Patient add = patientService.addPatientWithUser(patient);
    *	return ResponseEntity.status(HttpStatus.CREATED).body(add);
    *}
    */

    /*
     * AIM   : Get a patient’s medical history using patient ID.
     * PATH  : /api/patient/{id}
     * METHOD: GET
     * ROLE  : Any authorized user
     * RETURN: List of MedicalHistoryDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientWithMedicalHistory (@PathVariable int id){
    	PatientDTO get = patientService.getPatientWithMedicalHistory(id);
    	return ResponseEntity.status(HttpStatus.OK).body(get);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody PatientHistoryRequest request) {
        Patient saved = patientService.saveFullPatient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    
    
    
}