package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.service.AppointmentService;

@RestController
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	/*
	 * # AIM    : Book an appointment with a doctor
	 * # PATH   : /api/appointment/{patientId}/{doctorId}
	 * # METHOD : POST
	 * # PARAM  : Path Variable (patientId, doctorId), Request Body (Appointment)
	 * # RETURN : Appointment
	 */
	@PostMapping("/api/appointment/{patientId}/{doctorId}")
	public Appointment bookAppointment(@PathVariable int patientId,
									   @PathVariable int doctorId,
									   @RequestBody Appointment appointment) {
		return appointmentService.bookAppointment(patientId, doctorId, appointment);
	}

	/*
	 * # AIM    : Get all appointments
	 * # PATH   : /api/appointment
	 * # METHOD : GET
	 * # RETURN : List<Appointment>
	 */
	@GetMapping("/api/appointment")
	public List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	/*
	 * # AIM    : Get appointments for a doctor
	 * # PATH   : /api/appointment/doctor/{doctorId}
	 * # METHOD : GET
	 * # RETURN : List<Appointment>
	 */
	@GetMapping("/api/appointment/doctor/{doctorId}")
	public List<Appointment> getAppointmentsByDoctor(@PathVariable int doctorId) {
		return appointmentService.getAppointmentsByDoctor(doctorId);
	}

	/*
	 * # AIM    : Get appointments for a patient
	 * # PATH   : /api/appointment/patient/{patientId}
	 * # METHOD : GET
	 * # RETURN : List<Appointment>
	 */
	@GetMapping("/api/appointment/patient/{patientId}")
	public List<Appointment> getAppointmentsByPatient(@PathVariable int patientId) {
		return appointmentService.getAppointmentsByPatient(patientId);
	}

	/*
	 * # AIM    : Update an appointment
	 * # PATH   : /api/appointment/{appointmentId}
	 * # METHOD : PUT
	 * # PARAM  : Path Variable (appointmentId), Request Body (Appointment)
	 * # RETURN : Updated Appointment
	 */
	@PutMapping("/api/appointment/{appointmentId}")
	public Appointment updateAppointment(@PathVariable int appointmentId, @RequestBody Appointment updated) {
		return appointmentService.updateAppointment(appointmentId, updated);
	}

	/*
	 * # AIM    : Cancel/Delete an appointment
	 * # PATH   : /api/appointment/{appointmentId}
	 * # METHOD : DELETE
	 * # RETURN : String
	 */
	@DeleteMapping("/api/appointment/{appointmentId}")
	public String deleteAppointment(@PathVariable int appointmentId) {
		appointmentService.deleteAppointment(appointmentId);
		return "Appointment cancelled successfully";
	}

}
