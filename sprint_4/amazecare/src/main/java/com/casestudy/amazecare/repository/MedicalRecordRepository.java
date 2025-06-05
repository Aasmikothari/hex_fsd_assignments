package com.casestudy.amazecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.casestudy.amazecare.model.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {

    List<MedicalRecord> findByAppointmentId(int appointmentId);
}
