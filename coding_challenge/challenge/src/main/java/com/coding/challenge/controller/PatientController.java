package com.coding.challenge.controller;

import com.coding.challenge.dto.MedicalHistoryDTO;
import com.coding.challenge.dto.PatientHistoryDTO;
import com.coding.challenge.model.Patient;
import com.coding.challenge.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     */
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatientWithHistory(@RequestBody PatientHistoryDTO requestDTO) {
        Patient patient = requestDTO.getPatient();
        patient.setUser(requestDTO.getUser());
        Patient saved = patientService.addPatientWithMedicalHistory(patient, requestDTO.getMedicalHistories());
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /*
     * AIM   : Book an appointment for a patient with a doctor (links doctor to patient).
     * PATH  : /api/patient/book/{patientId}/{doctorId}
     * METHOD: POST
     * ROLE  : PERMIT ALL
     * RETURN: Updated patient object
     */
    @PostMapping("/book/{patientId}/{doctorId}")
    public ResponseEntity<Patient> bookAppointment(@PathVariable int patientId, @PathVariable int doctorId) {
        Patient updated = patientService.bookAppointment(patientId, doctorId);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    /*
     * AIM   : Get a patient’s medical history using patient ID.
     * PATH  : /api/patient/history/{id}
     * METHOD: GET
     * ROLE  : Any authorized user
     * RETURN: List of MedicalHistoryDTO
     */
    @GetMapping("/history/{id}")
    public ResponseEntity<List<MedicalHistoryDTO>> getMedicalHistoryByPatientId(@PathVariable int id) {
        List<MedicalHistoryDTO> histories = patientService.getMedicalHistoryForPatient(id);
        return ResponseEntity.ok(histories);
    }
}