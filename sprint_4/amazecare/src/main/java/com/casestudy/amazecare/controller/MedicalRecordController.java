package com.casestudy.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.MedicalRecord;
import com.casestudy.amazecare.service.MedicalRecordService;

@RestController
public class MedicalRecordController {

	@Autowired
	private MedicalRecordService medicalRecordService;
	
	/*
	 * # AIM    : Create a medical record with appointment, consultation, and prescription
	 * # PATH   : /api/medicalrecord/{appointmentId}/{consultationId}/{prescriptionId}
	 * # METHOD : POST
	 * # PARAM  : Path Variables (appointmentId, consultationId, prescriptionId),
	 *            Request Body (MedicalRecord)
	 * # RETURN : MedicalRecord
	 */
	@PostMapping("/api/medicalrecord/{appointmentId}/{consultationId}/{prescriptionId}")
	public MedicalRecord createMedicalRecord(@PathVariable int appointmentId,
											 @PathVariable int consultationId,
											 @PathVariable int prescriptionId,
											 @RequestBody MedicalRecord record) {
		return medicalRecordService.createMedicalRecord(appointmentId, consultationId, prescriptionId, record);
	}

	/*
	 * # AIM    : Get all medical records for a specific appointment
	 * # PATH   : /api/medicalrecord/appointment/{appointmentId}
	 * # METHOD : GET
	 * # RETURN : List<MedicalRecord>
	 */
	@GetMapping("/api/medicalrecord/appointment/{appointmentId}")
	public List<MedicalRecord> getRecordsByAppointment(@PathVariable int appointmentId) {
		return medicalRecordService.getRecordsByAppointment(appointmentId);
	}

	/*
	 * # AIM    : Update a medical record
	 * # PATH   : /api/medicalrecord/{recordId}
	 * # METHOD : PUT
	 * # PARAM  : Path Variable (recordId), Request Body (MedicalRecord)
	 * # RETURN : Updated MedicalRecord
	 */
	@PutMapping("/api/medicalrecord/{recordId}")
	public MedicalRecord updateMedicalRecord(@PathVariable int recordId,
											 @RequestBody MedicalRecord updated) {
		return medicalRecordService.updateMedicalRecord(recordId, updated);
	}

	/*
	 * # AIM    : Delete a medical record
	 * # PATH   : /api/medicalrecord/{recordId}
	 * # METHOD : DELETE
	 * # RETURN : String
	 */
	@DeleteMapping("/api/medicalrecord/{recordId}")
	public String deleteMedicalRecord(@PathVariable int recordId) {
		medicalRecordService.deleteMedicalRecord(recordId);
		return "Medical record deleted successfully";
	}

	
}