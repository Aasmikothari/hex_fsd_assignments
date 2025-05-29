package com.casestudy.amazecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.casestudy.amazecare.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

    List<Prescription> findByConsultationId(int consultationId);
}
