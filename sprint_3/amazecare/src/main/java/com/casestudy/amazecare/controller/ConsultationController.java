package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.service.ConsultationService;

@RestController
public class ConsultationController {

	@Autowired
	private ConsultationService consultationService;
	
	/*
	 * # AIM    : Add consultation notes to an appointment
	 * # PATH   : /api/consultation/{appointmentId}
	 * # METHOD : POST
	 * # PARAM  : Path Variable (appointmentId), Request Body (Consultation)
	 * # RETURN : Consultation
	 */
	@PostMapping("/api/consultation/{appointmentId}")
	public Consultation addConsultation(@PathVariable int appointmentId,
										@RequestBody Consultation consultation) {
		return consultationService.addConsultation(appointmentId, consultation);
	}

	/*
	 * # AIM    : Get all consultations for an appointment
	 * # PATH   : /api/consultation/appointment/{appointmentId}
	 * # METHOD : GET
	 * # RETURN : List<Consultation>
	 */
	@GetMapping("/api/consultation/appointment/{appointmentId}")
	public List<Consultation> getConsultationsByAppointment(@PathVariable int appointmentId) {
		return consultationService.getConsultationsByAppointment(appointmentId);
	}

	/*
	 * # AIM    : Update consultation notes
	 * # PATH   : /api/consultation/{consultationId}
	 * # METHOD : PUT
	 * # PARAM  : Path Variable (consultationId), Request Body (Consultation)
	 * # RETURN : Updated Consultation
	 */
	@PutMapping("/api/consultation/{consultationId}")
	public Consultation updateConsultation(@PathVariable int consultationId,
										   @RequestBody Consultation updated) {
		return consultationService.updateConsultation(consultationId, updated);
	}

	/*
	 * # AIM    : Delete a consultation
	 * # PATH   : /api/consultation/{consultationId}
	 * # METHOD : DELETE
	 * # RETURN : String
	 */
	@DeleteMapping("/api/consultation/{consultationId}")
	public String deleteConsultation(@PathVariable int consultationId) {
		consultationService.deleteConsultation(consultationId);
		return "Consultation deleted successfully";
	}

}
