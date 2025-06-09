package com.coding.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.challenge.exception.ResourceNotFoundException;
import com.coding.challenge.model.Doctor;
import com.coding.challenge.model.Patient;
import com.coding.challenge.model.User;
import com.coding.challenge.repository.DoctorRepository;
import com.coding.challenge.repository.UserRepository;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    
    @Autowired
    private UserRepository userRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Api-3: Get all Patients by Doctor ID 
    public List<Patient> getPatientsByDoctorId(int doctorId) {
        // Find doctor or throw exception if not found
        Doctor doctor = doctorRepository.findById(doctorId)
            .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + doctorId));

        // Return the list of patients associated with this doctor
        return doctor.getPatients().stream().toList();
    }
    
    public Doctor addDoctor(Doctor doctor) {
        User savedUser = userRepository.save(doctor.getUser());
        doctor.setUser(savedUser);
        return doctorRepository.save(doctor);
    }

}
