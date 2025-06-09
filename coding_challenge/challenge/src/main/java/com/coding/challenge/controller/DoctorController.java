package com.coding.challenge.controller;

import com.coding.challenge.model.Doctor;
import com.coding.challenge.model.Patient;
import com.coding.challenge.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /*
     * AIM: Get all patients for a given doctor ID.
     * PATH: /api/doctor/patients/{id}
     * METHOD: GET
     * ROLE: DOCTOR ONLY
     * RETURN: List of Patient
     */
    @GetMapping("/patients/{id}")
    public ResponseEntity<List<Patient>> getPatientsByDoctorId(@PathVariable int id) {
        List<Patient> patients = doctorService.getPatientsByDoctorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(patients);
    }
    
    /*
     * AIM: Add new doctor with user details.
     * PATH: /api/doctor/add
     * METHOD: POST
     * ROLE: ADMIN or permitAll for testing
     */
    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.addDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
    }
}
