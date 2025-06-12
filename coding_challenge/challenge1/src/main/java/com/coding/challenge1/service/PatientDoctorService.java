package com.coding.challenge1.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coding.challenge1.model.Doctor;
import com.coding.challenge1.model.Patient;
import com.coding.challenge1.model.PatientDoctor;
import com.coding.challenge1.model.Speciality;
import com.coding.challenge1.repository.DoctorRepository;
import com.coding.challenge1.repository.PatientDoctorRepository;
import com.coding.challenge1.repository.PatientRepository;

@Service
public class PatientDoctorService {
	
	private final PatientDoctorRepository pdRepository;
	private final PatientRepository patientRepository;
	private final DoctorRepository doctorRepository;
	
	public PatientDoctorService(PatientDoctorRepository pdRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
		this.pdRepository = pdRepository;
		this.patientRepository = patientRepository;
		this.doctorRepository = doctorRepository;
	}
	
	//get patient by doctor id
	public List<Patient> getPatientByDoctorId(int doctorId){
		return pdRepository.getPatientByDoctorId(doctorId);
	}
	
	//add appointment with doctor id ->appointment
	public PatientDoctor addPatientWithDoctorId(int patientId, int doctorId) {
		
		Patient patient = patientRepository.findPatientById(patientId);
        Doctor doctor = doctorRepository.findDoctorById(doctorId);
        
        PatientDoctor appointment = new PatientDoctor();
        appointment.setDate(LocalDate.now());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        
        return pdRepository.save(appointment);
	}
	
	//get list of patients based on specialization
	public List<Patient> getPatientByDoctorSpeciality (Speciality speciality) {
		return pdRepository.getDoctorBySpeciality(speciality);
	}

}
