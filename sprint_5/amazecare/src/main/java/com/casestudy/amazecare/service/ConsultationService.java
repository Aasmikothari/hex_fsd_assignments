package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.ConsultationRepository;
import com.casestudy.amazecare.repository.PatientRepository;

@Service
public class ConsultationService {

    private ConsultationRepository consultationRepository;
    private AppointmentRepository appointmentRepository;
    private PatientRepository patientRepository;

    public ConsultationService(ConsultationRepository consultationRepository,
                               AppointmentRepository appointmentRepository,
                               PatientRepository patientRepository) {
        super();
        this.consultationRepository = consultationRepository;
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    // Add or update consultation details for an appointment
    public Consultation addOrUpdateConsultation(int appointmentId, Consultation consultation) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        consultation.setAppointment(appointment);
        consultation.setPatient(appointment.getPatient());

        return consultationRepository.save(consultation);
    }

    // Get consultation by appointment ID
    public Consultation getConsultationByAppointmentId(int appointmentId) {
        return consultationRepository.findByAppointmentId(appointmentId);
    }

    // Get all consultations of a patient by patient ID
    public List<Consultation> getConsultationsByPatientId(int patientId) {
        return consultationRepository.findByPatientId(patientId);
    }
}