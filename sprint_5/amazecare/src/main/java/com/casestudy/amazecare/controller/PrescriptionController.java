package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Prescription;
import com.casestudy.amazecare.service.PrescriptionService;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    /*
     * AIM    : Get all prescriptions by appointment ID
     * METHOD : GET
     * PATH   : /api/prescriptions/appointment/{appointmentId}
     * RESPONSE : List of Prescription objects
     */
    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByAppointment(@PathVariable int appointmentId) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByAppointmentId(appointmentId);
        return ResponseEntity.ok(prescriptions);
    }

    /*
     * AIM    : Add a new prescription for an appointment
     * METHOD : POST
     * PATH   : /api/prescriptions/{appointmentId}
     * RESPONSE : Created Prescription object
     */
    @PostMapping("/{appointmentId}")
    public ResponseEntity<Prescription> addPrescription(@PathVariable int appointmentId,
                                                        @RequestBody Prescription prescription) {
        Prescription savedPrescription = prescriptionService.addPrescription(appointmentId, prescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPrescription);
    }
}