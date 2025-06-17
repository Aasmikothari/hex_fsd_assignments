package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Department;
import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.service.AdminService;
import com.casestudy.amazecare.service.DepartmentService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private DepartmentService departmentService;

    /*
     * AIM    : Get all doctors
     * METHOD : GET
     * PATH   : /api/admin/doctors
     * RESPONSE : List of Doctor objects
     */
    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(adminService.getAllDoctors());
    }

    /*
     * AIM    : Add a new doctor
     * METHOD : POST
     * PATH   : /api/admin/doctors
     * RESPONSE : Created Doctor object
     */
    @PostMapping("/doctors")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addDoctor(doctor));
    }

    /*
     * AIM    : Update doctor details
     * METHOD : PUT
     * PATH   : /api/admin/doctors/{doctorId}
     * RESPONSE : Updated Doctor object
     */
    @PutMapping("/doctors/{doctorId}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable int doctorId, @RequestBody Doctor doctor) {
        return ResponseEntity.ok(adminService.updateDoctor(doctorId, doctor));
    }

    /*
     * AIM    : Delete a doctor by ID
     * METHOD : DELETE
     * PATH   : /api/admin/doctors/{doctorId}
     * RESPONSE : String message
     */
    @DeleteMapping("/doctors/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int doctorId) {
        adminService.deleteDoctor(doctorId);
        return ResponseEntity.ok("Doctor deleted successfully");
    }

    /*
     * AIM    : Get all patients
     * METHOD : GET
     * PATH   : /api/admin/patients
     * RESPONSE : List of Patient objects
     */
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(adminService.getAllPatients());
    }

    /*
     * AIM    : Add a new patient
     * METHOD : POST
     * PATH   : /api/admin/patients
     * RESPONSE : Created Patient object
     */
    @PostMapping("/patients")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addPatient(patient));
    }

    /*
     * AIM    : Update patient details
     * METHOD : PUT
     * PATH   : /api/admin/patients/{patientId}
     * RESPONSE : Updated Patient object
     */
    @PutMapping("/patients/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int patientId, @RequestBody Patient patient) {
        return ResponseEntity.ok(adminService.updatePatient(patientId, patient));
    }

    /*
     * AIM    : Delete a patient by ID
     * METHOD : DELETE
     * PATH   : /api/admin/patients/{patientId}
     * RESPONSE : String message
     */
    @DeleteMapping("/patients/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable int patientId) {
        adminService.deletePatient(patientId);
        return ResponseEntity.ok("Patient deleted successfully");
    }

    /*
     * AIM    : Get all appointments
     * METHOD : GET
     * PATH   : /api/admin/appointments
     * RESPONSE : List of Appointment objects
     */
    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(adminService.getAllAppointments());
    }
    
    @PostMapping("/departments")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department saved = departmentService.addDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}