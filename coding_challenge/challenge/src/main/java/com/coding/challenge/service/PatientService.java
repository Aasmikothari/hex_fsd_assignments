package com.coding.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.challenge.exception.ResourceNotFoundException;
import com.coding.challenge.model.Doctor;
import com.coding.challenge.model.MedicalHistory;
import com.coding.challenge.model.Patient;
import com.coding.challenge.model.User;
import com.coding.challenge.repository.DoctorRepository;
import com.coding.challenge.repository.MedicalHistoryRepository;
import com.coding.challenge.repository.PatientRepository;
import com.coding.challenge.repository.UserRepository;
import com.coding.challenge.dto.MedicalHistoryDTO;

import java.util.Set;
import java.util.List;

@Service
public class PatientService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;

	// Api-1: Save patient with user and medical history data
	public Patient addPatientWithMedicalHistory(Patient patient, Set<MedicalHistory> histories) {
		User savedUser = userRepository.save(patient.getUser());
		patient.setUser(savedUser);
		Patient savedPatient = patientRepository.save(patient);
		for (MedicalHistory history : histories) {
			history.setPatient(savedPatient); // link back
			medicalHistoryRepository.save(history);
		}
		return savedPatient;
	}
	
	// Api-2: Book appointment = Add doctor to patient's doctor set
	public Patient bookAppointment(int patientId, int doctorId) {
		Patient patient = patientRepository.findById(patientId)
			.orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

		Doctor doctor = doctorRepository.findById(doctorId)
			.orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + doctorId));

		if (patient.getDoctors() == null) {
			patient.setDoctors(new java.util.HashSet<>());
		}

		patient.getDoctors().add(doctor);
		return patientRepository.save(patient);
	}
	
	// Api-4: Get patient medical history by ID with DTO
	public List<MedicalHistoryDTO> getMedicalHistoryForPatient(int patientId) {
	    // Check if patient exists
	    Patient patient = patientRepository.findById(patientId)
	        .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

	    // Fetch projected history records
	    return medicalHistoryRepository.findHistoryByPatientId(patientId);
	}


}