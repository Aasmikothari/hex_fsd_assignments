package com.casestudy.amazecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.casestudy.amazecare.model.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

    List<Consultation> findByAppointmentId(int appointmentId);
}
