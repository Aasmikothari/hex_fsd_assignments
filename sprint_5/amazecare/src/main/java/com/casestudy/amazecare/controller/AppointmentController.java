package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    /*
     * AIM    : Get appointment by appointment ID
     * METHOD : GET
     * PATH   : /api/appointments/{appointmentId}
     * RESPONSE : Appointment object
     */
    @GetMapping("/{appointmentId}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable int appointmentId) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        return ResponseEntity.ok(appointment);
    }

    /*
     * AIM    : Reschedule an appointment (change date & time)
     * METHOD : PUT
     * PATH   : /api/appointments/{appointmentId}/reschedule
     * RESPONSE : Updated Appointment object
     */
    @PutMapping("/{appointmentId}/reschedule")
    public ResponseEntity<Appointment> rescheduleAppointment(@PathVariable int appointmentId,
                                                             @RequestParam String newDate,
                                                             @RequestParam String newTime) {
        Appointment rescheduled = appointmentService.rescheduleAppointment(appointmentId, newDate, newTime);
        return ResponseEntity.ok(rescheduled);
    }

    /*
     * AIM    : Cancel an appointment
     * METHOD : PUT
     * PATH   : /api/appointments/{appointmentId}/cancel
     * RESPONSE : Updated Appointment object with CANCELLED status
     */
    @PutMapping("/{appointmentId}/cancel")
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable int appointmentId) {
        Appointment cancelled = appointmentService.cancelAppointment(appointmentId);
        return ResponseEntity.ok(cancelled);
    }

    /*
     * AIM    : Get all appointments by status (e.g., PENDING, CONFIRMED)
     * METHOD : GET
     * PATH   : /api/appointments/status/{status}
     * RESPONSE : List of Appointment objects
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Appointment>> getAppointmentsByStatus(@PathVariable String status) {
        List<Appointment> appointments = appointmentService.getAppointmentsByStatus(status);
        return ResponseEntity.ok(appointments);
    }

    /*
     * AIM    : Get all appointments of a doctor
     * METHOD : GET
     * PATH   : /api/appointments/doctor/{doctorId}
     * RESPONSE : List of Appointment objects
     */
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(@PathVariable int doctorId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(doctorId);
        return ResponseEntity.ok(appointments);
    }

    /*
     * AIM    : Get all appointments of a patient
     * METHOD : GET
     * PATH   : /api/appointments/patient/{patientId}
     * RESPONSE : List of Appointment objects
     */
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatient(@PathVariable int patientId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPatientId(patientId);
        return ResponseEntity.ok(appointments);
    }
}