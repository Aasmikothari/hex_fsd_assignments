package com.coding.challenge1.controller;

import com.coding.challenge1.model.Doctor;
import com.coding.challenge1.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    
    /*
     * AIM: Add new doctor with user details.
     * PATH: /api/doctor/add
     * METHOD: POST
     * ROLE: ADMIN or permitAll
     */
    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.add(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
    }
}
