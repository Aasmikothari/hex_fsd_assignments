package com.coding.challenge1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coding.challenge1.dto.PatientDTO;
import com.coding.challenge1.model.MedicalHistory;
import com.coding.challenge1.model.Patient;
import com.coding.challenge1.model.PatientHistoryRequest;
import com.coding.challenge1.model.User;
import com.coding.challenge1.repository.MedicalHistoryRepository;
import com.coding.challenge1.repository.PatientRepository;

@Service
public class PatientService {
	
	private final PatientRepository patientRepository;
	private final UserService userService;
	private final MedicalHistoryRepository medicalhistoryRepository;
	
	
	public PatientService(PatientRepository patientRepository, UserService userService, MedicalHistoryRepository medicalhistoryRepository) {
		this.patientRepository = patientRepository;
		this.userService = userService;
		this.medicalhistoryRepository = medicalhistoryRepository;
	}

	/*
	* add patient with user
	*public Patient addPatientWithUser (Patient patient) {
	*	 User user = patient.getUser();
    *    user.setRole("PATIENT");
    *    user = userService.signUp(user);
    *    patient.setUser(user);
    *    return patientRepository.save(patient);
	*}
	*/
	
	//get patient along with medical history
	public PatientDTO getPatientWithMedicalHistory (int patientId){
		Patient patient = patientRepository.findPatientById(patientId);
		List<MedicalHistory> medicalHistories = medicalhistoryRepository.findByPatientId(patientId);
	    return PatientDTO.convertPatientToDto(patient, medicalHistories);
	}
	
	//add patient with user and medicalhistory
	public Patient saveFullPatient(PatientHistoryRequest request) {
	    // Attach the user to the patient
	    Patient patient = request.getPatient();
	    patient.setUser(request.getUser());

	    // Save patient with user
	    Patient savedPatient = patientRepository.save(patient);

	    // Attach each history with saved patient and save them
	    for (MedicalHistory mh : request.getMedicalHistories()) {
	        mh.setPatient(savedPatient);
	        medicalhistoryRepository.save(mh);
	    }

	    return savedPatient;
	}

}