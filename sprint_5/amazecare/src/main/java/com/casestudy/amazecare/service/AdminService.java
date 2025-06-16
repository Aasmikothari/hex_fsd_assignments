package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.DoctorRepository;
import com.casestudy.amazecare.repository.PatientRepository;

@Service
public class AdminService {

    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    private AppointmentRepository appointmentRepository;

    public AdminService(DoctorRepository doctorRepository, PatientRepository patientRepository,
                        AppointmentRepository appointmentRepository) {
        super();
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    // Add new doctor
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Update existing doctor by ID
    public Doctor updateDoctor(int doctorId, Doctor updatedDoctor) {
        Doctor existingDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + doctorId));

        existingDoctor.setName(updatedDoctor.getName());
        existingDoctor.setSpecialty(updatedDoctor.getSpecialty());
        existingDoctor.setExperience(updatedDoctor.getExperience());
        existingDoctor.setQualification(updatedDoctor.getQualification());
        existingDoctor.setDesignation(updatedDoctor.getDesignation());
        existingDoctor.setDepartment(updatedDoctor.getDepartment());
        existingDoctor.setUser(updatedDoctor.getUser());

        return doctorRepository.save(existingDoctor);
    }

    // Delete doctor by ID
    public void deleteDoctor(int doctorId) {
        Doctor existingDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + doctorId));
        doctorRepository.delete(existingDoctor);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Add new patient
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Update existing patient by ID
    public Patient updatePatient(int patientId, Patient updatedPatient) {
        Patient existingPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

        existingPatient.setFullName(updatedPatient.getFullName());
        existingPatient.setGender(updatedPatient.getGender());
        existingPatient.setDob(updatedPatient.getDob());
        existingPatient.setContact(updatedPatient.getContact());
        existingPatient.setUser(updatedPatient.getUser());

        return patientRepository.save(existingPatient);
    }

    // Delete patient by ID
    public void deletePatient(int patientId) {
        Patient existingPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));
        patientRepository.delete(existingPatient);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get all appointments (for admin view)
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get appointment by ID
    public Appointment getAppointmentById(int appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));
    }
}