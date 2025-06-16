package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.model.Prescription;
import com.casestudy.amazecare.model.Test;
import com.casestudy.amazecare.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /*
     * AIM    : Get doctors by department name
     * METHOD : GET
     * PATH   : /api/doctors/department/{deptName}
     * RESPONSE : List of Doctor objects in that department
     */
    @GetMapping("/department/{deptName}")
    public ResponseEntity<List<Doctor>> getDoctorsByDepartment(@PathVariable String deptName) {
        List<Doctor> doctors = doctorService.getDoctorsByDepartmentName(deptName);
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    /*
     * AIM    : Get doctor by User ID (login purpose)
     * METHOD : GET
     * PATH   : /api/doctors/user/{userId}
     * RESPONSE : Doctor object
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<Doctor> getDoctorByUserId(@PathVariable int userId) {
        Doctor doctor = doctorService.getDoctorByUserId(userId);
        return ResponseEntity.ok(doctor);
    }

    /*
     * AIM    : Get all appointments of doctor by status
     * METHOD : GET
     * PATH   : /api/doctors/{doctorId}/appointments/{status}
     * RESPONSE : List of Appointment objects
     */
    @GetMapping("/{doctorId}/appointments/{status}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorAndStatus(@PathVariable int doctorId, @PathVariable String status) {
        List<Appointment> appointments = doctorService.getAppointmentsByDoctorAndStatus(doctorId, status);
        return ResponseEntity.ok(appointments);
    }

    /*
     * AIM    : Add or update consultation for an appointment
     * METHOD : POST
     * PATH   : /api/doctors/{appointmentId}/consultation
     * RESPONSE : Created/Updated Consultation object
     */
    @PostMapping("/{appointmentId}/consultation")
    public ResponseEntity<Consultation> addOrUpdateConsultation(@PathVariable int appointmentId, @RequestBody Consultation consultation) {
        Consultation savedConsultation = doctorService.addOrUpdateConsultation(appointmentId, consultation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedConsultation);
    }

    /*
     * AIM    : Prescribe medicine for an appointment
     * METHOD : POST
     * PATH   : /api/doctors/{appointmentId}/prescription
     * RESPONSE : Created Prescription object
     */
    @PostMapping("/{appointmentId}/prescription")
    public ResponseEntity<Prescription> prescribeMedicine(@PathVariable int appointmentId, @RequestBody Prescription prescription) {
        Prescription savedPrescription = doctorService.prescribeMedicine(appointmentId, prescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPrescription);
    }

    /*
     * AIM    : Get all tests for an appointment
     * METHOD : GET
     * PATH   : /api/doctors/{appointmentId}/tests
     * RESPONSE : List of Test objects
     */
    @GetMapping("/{appointmentId}/tests")
    public ResponseEntity<List<Test>> getTestsByAppointmentId(@PathVariable int appointmentId) {
        List<Test> tests = doctorService.getTestsByAppointmentId(appointmentId);
        return ResponseEntity.ok(tests);
    }
}