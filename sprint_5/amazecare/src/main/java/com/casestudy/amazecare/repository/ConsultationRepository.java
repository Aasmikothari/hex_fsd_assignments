package com.casestudy.amazecare.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.casestudy.amazecare.model.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

    // Get all consultations by patient ID
    @Query("SELECT c FROM Consultation c WHERE c.patient.id = ?1")
    List<Consultation> findByPatientId(int patientId);

    // Get consultation by appointment ID
    @Query("SELECT c FROM Consultation c WHERE c.appointment.id = ?1")
    Consultation findByAppointmentId(int appointmentId);
}