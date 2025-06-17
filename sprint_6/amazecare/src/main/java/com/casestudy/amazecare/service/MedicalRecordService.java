package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.MedicalRecord;
import com.casestudy.amazecare.model.Patient;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.MedicalRecordRepository;
import com.casestudy.amazecare.repository.PatientRepository;

@Service
public class MedicalRecordService {

    private MedicalRecordRepository medicalRecordRepository;
    private AppointmentRepository appointmentRepository;
    private PatientRepository patientRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository,
    		AppointmentRepository appointmentRepository,
    		PatientRepository patientRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    // Get all medical records of a patient by patient ID
    public List<MedicalRecord> getMedicalRecordsByPatientId(int patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    // Get medical record by appointment ID
    public MedicalRecord getMedicalRecordByAppointmentId(int appointmentId) {
        return medicalRecordRepository.findByAppointmentId(appointmentId);
    }
    
    public MedicalRecord saveOrUpdateMedicalRecord(MedicalRecord record, int appointmentId, int patientId) {
        // Optionally check if appointment/patient exist
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

        record.setAppointment(appointment);
        record.setPatient(patient);

        return medicalRecordRepository.save(record);
    }

	public List<MedicalRecord> getAllMedicalRecordsByDoctorId(int doctorId) {
		return medicalRecordRepository.findAllByDoctorId(doctorId);
	}
}