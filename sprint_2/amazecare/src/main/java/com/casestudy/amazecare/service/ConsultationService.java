package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.amazecare.exception.ResourceNotFoundException;
import com.casestudy.amazecare.model.Appointment;
import com.casestudy.amazecare.model.Consultation;
import com.casestudy.amazecare.repository.AppointmentRepository;
import com.casestudy.amazecare.repository.ConsultationRepository;

/**
 * Service class for handling business logic related to Consultations.
 */
@Service
public class ConsultationService {

    private ConsultationRepository consultationRepository;
    private AppointmentRepository appointmentRepository;

    public ConsultationService(ConsultationRepository consultationRepository,
                               AppointmentRepository appointmentRepository) {
        super();
        this.consultationRepository = consultationRepository;
        this.appointmentRepository = appointmentRepository;
    }

}