package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.Prescription;
import com.casestudy.amazecare.service.PrescriptionService;

@RestController
public class PrescriptionController {

	@Autowired
	private PrescriptionService prescriptionService;
	
	/*
	 * # AIM    : Add a prescription for a consultation
	 * # PATH   : /api/prescription/{consultationId}
	 * # METHOD : POST
	 * # PARAM  : Path Variable (consultationId), Request Body (Prescription)
	 * # RETURN : Prescription
	 */
	@PostMapping("/api/prescription/{consultationId}")
	public Prescription addPrescription(@PathVariable int consultationId,
										@RequestBody Prescription prescription) {
		return prescriptionService.addPrescription(consultationId, prescription);
	}

	/*
	 * # AIM    : Get all prescriptions for a consultation
	 * # PATH   : /api/prescription/consultation/{consultationId}
	 * # METHOD : GET
	 * # RETURN : List<Prescription>
	 */
	@GetMapping("/api/prescription/consultation/{consultationId}")
	public List<Prescription> getPrescriptionsByConsultation(@PathVariable int consultationId) {
		return prescriptionService.getPrescriptionsByConsultation(consultationId);
	}

	/*
	 * # AIM    : Update a prescription by ID
	 * # PATH   : /api/prescription/{prescriptionId}
	 * # METHOD : PUT
	 * # PARAM  : Path Variable (prescriptionId), Request Body (Prescription)
	 * # RETURN : Updated Prescription
	 */
	@PutMapping("/api/prescription/{prescriptionId}")
	public Prescription updatePrescription(@PathVariable int prescriptionId,
										   @RequestBody Prescription updated) {
		return prescriptionService.updatePrescription(prescriptionId, updated);
	}

	/*
	 * # AIM    : Delete a prescription by ID
	 * # PATH   : /api/prescription/{prescriptionId}
	 * # METHOD : DELETE
	 * # RETURN : String
	 */
	@DeleteMapping("/api/prescription/{prescriptionId}")
	public String deletePrescription(@PathVariable int prescriptionId) {
		prescriptionService.deletePrescription(prescriptionId);
		return "Prescription deleted successfully";
	}

	
}
