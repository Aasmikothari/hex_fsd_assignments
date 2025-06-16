package com.casestudy.amazecare.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Admin;
import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.model.User;
import com.casestudy.amazecare.repository.AdminRepository;
import com.casestudy.amazecare.repository.DoctorRepository;
import com.casestudy.amazecare.repository.PatientRepository;
import com.casestudy.amazecare.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AdminRepository adminRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       AdminRepository adminRepository, DoctorRepository doctorRepository,
                       PatientRepository patientRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.adminRepository = adminRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    // Save user with encoded password
    public User signUp(User user) {
        String plainPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    // Get user info (Doctor, Patient, Admin) based on role
    public Object getUserInfo(String username) {
        User user = userRepository.getByUsername(username);
        switch (user.getRole().toUpperCase()) {
            case "ADMIN":
                Admin admin = adminRepository.findByUsername(username);
                if(admin != null)
                    return admin;
                else
                    throw new ResourceNotFoundException("Admin not found");
            case "DOCTOR":
                Doctor doctor = doctorRepository.findByUsername(username);
                if(doctor != null)
                    return doctor;
                else
                    throw new ResourceNotFoundException("Doctor not found");
            case "PATIENT":
                Patient patient = patientRepository.findByUsername(username);
                if(patient != null)
                    return patient;
                else
                    throw new ResourceNotFoundException("Patient not found");
            default:
                throw new RuntimeException("Unknown role: " + user.getRole());
        }
    }
    
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}