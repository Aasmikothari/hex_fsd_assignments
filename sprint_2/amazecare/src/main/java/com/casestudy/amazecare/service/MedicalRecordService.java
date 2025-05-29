package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.model.MedicalRecord;
import com.casestudy.amazecare.model.Prescription;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.ConsultationRepository;
import com.casestudy.amazecare.repository.MedicalRecordRepository;
import com.casestudy.amazecare.repository.PrescriptionRepository;

/**
 * Service class for handling business logic related to Medical Records.
 */
@Service
public class MedicalRecordService {

    private MedicalRecordRepository medicalRecordRepository;
    private AppointmentRepository appointmentRepository;
    private ConsultationRepository consultationRepository;
    private PrescriptionRepository prescriptionRepository;

    // Constructor-based injection
    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository,
                                AppointmentRepository appointmentRepository,
                                ConsultationRepository consultationRepository,
                                PrescriptionRepository prescriptionRepository) {
        super();
        this.medicalRecordRepository = medicalRecordRepository;
        this.appointmentRepository = appointmentRepository;
        this.consultationRepository = consultationRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    
}
