package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.MedicalRecord;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    /*
     * AIM    : Get patient profile by User ID
     * METHOD : GET
     * PATH   : /api/patient/user/{userId}
     * RESPONSE : Patient object
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<Patient> getPatientByUserId(@PathVariable int userId) {
        Patient patient = patientService.getPatientByUserId(userId);
        return ResponseEntity.ok(patient);
    }

    /*
     * AIM    : Book a new appointment
     * METHOD : POST
     * PATH   : /api/patient/{patientId}/appointments
     * RESPONSE : Created Appointment object
     */
    @PostMapping("/{patientId}/appointments")
    public ResponseEntity<Appointment> bookAppointment(@PathVariable int patientId, @RequestBody Appointment appointment) {
        Appointment booked = patientService.bookAppointment(appointment, patientId);
        return ResponseEntity.status(HttpStatus.CREATED).body(booked);
    }

    /*
     * AIM    : Cancel an appointment by appointment ID
     * METHOD : PUT
     * PATH   : /api/patient/appointments/{appointmentId}/cancel
     * RESPONSE : Updated Appointment object with CANCELLED status
     */
    @PutMapping("/appointments/{appointmentId}/cancel")
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable int appointmentId) {
        Appointment cancelled = patientService.cancelAppointment(appointmentId);
        return ResponseEntity.ok(cancelled);
    }

    /*
     * AIM    : Get all appointments of a patient by status
     * METHOD : GET
     * PATH   : /api/patient/{patientId}/appointments/{status}
     * RESPONSE : List of Appointment objects
     */
    @GetMapping("/{patientId}/appointments/{status}")
    public ResponseEntity<List<Appointment>> getAppointmentsByStatus(@PathVariable int patientId, @PathVariable String status) {
        List<Appointment> appointments = patientService.getAppointmentsByPatientAndStatus(patientId, status);
        return ResponseEntity.ok(appointments);
    }

    /*
     * AIM    : Get all medical records of a patient by patient ID
     * METHOD : GET
     * PATH   : /api/patient/{patientId}/medical-records
     * RESPONSE : List of MedicalRecord objects
     */
    @GetMapping("/{patientId}/medical-records")
    public ResponseEntity<List<MedicalRecord>> getMedicalRecords(@PathVariable int patientId) {
        List<MedicalRecord> records = patientService.getMedicalRecordsByPatientId(patientId);
        return ResponseEntity.ok(records);
    }
}