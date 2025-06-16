package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.model.MedicalRecord;
import com.casestudy.amazecare.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {

    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        super();
        this.medicalRecordRepository = medicalRecordRepository;
    }

    // Get all medical records of a patient by patient ID
    public List<MedicalRecord> getMedicalRecordsByPatientId(int patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    // Get medical record by appointment ID
    public MedicalRecord getMedicalRecordByAppointmentId(int appointmentId) {
        return medicalRecordRepository.findByAppointmentId(appointmentId);
    }
}