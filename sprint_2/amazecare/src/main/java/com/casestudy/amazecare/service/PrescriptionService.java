package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.model.Prescription;
import com.casestudy.amazecare.repository.ConsultationRepository;
import com.casestudy.amazecare.repository.PrescriptionRepository;

/**
 * Service class for handling business logic related to Prescriptions.
 */
@Service
public class PrescriptionService {

    private PrescriptionRepository prescriptionRepository;
    private ConsultationRepository consultationRepository;

    // Constructor-based dependency injection
    public PrescriptionService(PrescriptionRepository prescriptionRepository,
                               ConsultationRepository consultationRepository) {
        super();
        this.prescriptionRepository = prescriptionRepository;
        this.consultationRepository = consultationRepository;
    }
}
