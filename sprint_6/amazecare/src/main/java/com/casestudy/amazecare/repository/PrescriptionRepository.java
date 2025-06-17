package com.casestudy.amazecare.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.casestudy.amazecare.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

    // Get prescriptions by appointment ID
    @Query("SELECT p FROM Prescription p WHERE p.appointment.id = ?1")
    List<Prescription> findByAppointmentId(int appointmentId);
}
