package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Department;
import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.repository.DepartmentRepository;
import com.casestudy.amazecare.repository.DoctorRepository;

/**
 * Service class for handling business logic related to Doctors.
 */
@Service
public class DoctorService {

    private DoctorRepository doctorRepository;
    private DepartmentRepository departmentRepository;

    public DoctorService(DoctorRepository doctorRepository, DepartmentRepository departmentRepository) {
        super();
        this.doctorRepository = doctorRepository;
        this.departmentRepository = departmentRepository;
    }

    /**
     * Get all doctors in the system.
     * @return List of all doctors
     */
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    
    /**
     * Add a new doctor with department assignment.
     * @param deptId ID of the department to which the doctor belongs
     * @param doctor Doctor object with details like name, contact, etc.
     * @return The saved Doctor object
     * @throws ResourceNotFoundException if department is not found
     */
    public Doctor addDoctor(int deptId, Doctor doctor) {
        Department dept = departmentRepository.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with ID: " + deptId));

        doctor.setDepartment(dept);
        return doctorRepository.save(doctor);
    }

     /**
     * Get all doctors by department ID.
     * @param deptId Department ID
     * @return List of doctors in that department
     */
    public List<Doctor> getDoctorsByDepartmentId(int deptId) {
        return doctorRepository.findByDepartmentId(deptId);
    }

    /**
     * Get doctor by ID.
     * @param doctorId Doctor ID
     * @return Doctor object
     * @throws ResourceNotFoundException if doctor is not found
     */
    public Doctor getDoctorById(int doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + doctorId));
    }

    /**
     * Update doctor details by ID.
     * @param doctorId ID of doctor to update
     * @param updatedDoctor Updated fields
     * @return Updated doctor object
     * @throws ResourceNotFoundException if doctor is not found
     */
    public Doctor updateDoctor(int doctorId, Doctor updatedDoctor) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + doctorId));

        doctor.setName(updatedDoctor.getName());
        doctor.setEmail(updatedDoctor.getEmail());
        doctor.setContact(updatedDoctor.getContact());
        doctor.setQualification(updatedDoctor.getQualification());
        doctor.setDesignation(updatedDoctor.getDesignation());
        doctor.setExperience(updatedDoctor.getExperience());
        doctor.setPassword(updatedDoctor.getPassword());

        return doctorRepository.save(doctor);
    }

    /**
     * Delete a doctor by ID.
     * @param doctorId Doctor ID
     * @throws ResourceNotFoundException if doctor is not found
     */
    public void deleteDoctor(int doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + doctorId));
        doctorRepository.delete(doctor);
    }

}