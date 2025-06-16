package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.model.Doctor;
import com.casestudy.amazecare.model.Prescription;
import com.casestudy.amazecare.model.Test;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.ConsultationRepository;
import com.casestudy.amazecare.repository.DoctorRepository;
import com.casestudy.amazecare.repository.PrescriptionRepository;
import com.casestudy.amazecare.repository.TestRepository;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;
    private AppointmentRepository appointmentRepository;
    private ConsultationRepository consultationRepository;
    private PrescriptionRepository prescriptionRepository;
    private TestRepository testRepository;

    public DoctorService(DoctorRepository doctorRepository,
                         AppointmentRepository appointmentRepository,
                         ConsultationRepository consultationRepository,
                         PrescriptionRepository prescriptionRepository,
                         TestRepository testRepository) {
        super();
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.consultationRepository = consultationRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.testRepository = testRepository;
    }

    // Get doctor by user ID (for login purpose)
    public Doctor getDoctorByUserId(int userId) {
        return doctorRepository.findByUserId(userId);
    }

    // Get all appointments of doctor by status
    public List<Appointment> getAppointmentsByDoctorAndStatus(int doctorId, String status) {
        List<Appointment> allAppointments = appointmentRepository.findByDoctorId(doctorId);
        return allAppointments.stream()
                .filter(a -> a.getStatus().equalsIgnoreCase(status))
                .toList();
    }

    // Add or update consultation details for an appointment
    public Consultation addOrUpdateConsultation(int appointmentId, Consultation consultation) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        consultation.setAppointment(appointment);
        consultation.setPatient(appointment.getPatient());

        return consultationRepository.save(consultation);
    }

    // Prescribe medicine for an appointment
    public Prescription prescribeMedicine(int appointmentId, Prescription prescription) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        prescription.setAppointment(appointment);

        return prescriptionRepository.save(prescription);
    }

    // View all tests recommended for a particular appointment
    public List<Test> getTestsByAppointmentId(int appointmentId) {
        return testRepository.findByAppointmentId(appointmentId);
    }
    
    // Get doctors by department name
    public List<Doctor> getDoctorsByDepartmentName(String deptName) {
        return doctorRepository.findByDepartmentName(deptName);
    }
}