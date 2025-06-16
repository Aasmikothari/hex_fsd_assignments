package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.MedicalRecord;
import com.casestudy.amazecare.service.MedicalRecordService;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    /*
     * AIM    : Get all medical records of a patient by patient ID
     * METHOD : GET
     * PATH   : /api/medical-records/patient/{patientId}
     * RESPONSE : List of MedicalRecord objects
     */
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getMedicalRecordsByPatientId(@PathVariable int patientId) {
        List<MedicalRecord> records = medicalRecordService.getMedicalRecordsByPatientId(patientId);
        return ResponseEntity.ok(records);
    }

    /*
     * AIM    : Get medical record by appointment ID
     * METHOD : GET
     * PATH   : /api/medical-records/appointment/{appointmentId}
     * RESPONSE : MedicalRecord object
     */
    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<MedicalRecord> getMedicalRecordByAppointmentId(@PathVariable int appointmentId) {
        MedicalRecord record = medicalRecordService.getMedicalRecordByAppointmentId(appointmentId);
        return ResponseEntity.ok(record);
    }
}