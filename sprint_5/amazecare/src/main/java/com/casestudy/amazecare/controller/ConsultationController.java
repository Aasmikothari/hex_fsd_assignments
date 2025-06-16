package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.service.ConsultationService;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    /*
     * AIM    : Add or update consultation details for an appointment
     * METHOD : POST
     * PATH   : /api/consultations/{appointmentId}
     * RESPONSE : Created/Updated Consultation object
     */
    @PostMapping("/{appointmentId}")
    public ResponseEntity<Consultation> addOrUpdateConsultation(@PathVariable int appointmentId,
                                                                @RequestBody Consultation consultation) {
        Consultation savedConsultation = consultationService.addOrUpdateConsultation(appointmentId, consultation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedConsultation);
    }

    /*
     * AIM    : Get consultation details by appointment ID
     * METHOD : GET
     * PATH   : /api/consultations/appointment/{appointmentId}
     * RESPONSE : Consultation object
     */
    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<Consultation> getConsultationByAppointment(@PathVariable int appointmentId) {
        Consultation consultation = consultationService.getConsultationByAppointmentId(appointmentId);
        return ResponseEntity.ok(consultation);
    }

    /*
     * AIM    : Get all consultations of a patient
     * METHOD : GET
     * PATH   : /api/consultations/patient/{patientId}
     * RESPONSE : List of Consultation objects
     */
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Consultation>> getConsultationsByPatient(@PathVariable int patientId) {
        List<Consultation> consultations = consultationService.getConsultationsByPatientId(patientId);
        return ResponseEntity.ok(consultations);
    }
}