package com.casestudy.amazecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.casestudy.amazecare.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    // Get all appointments for a doctor
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = ?1")
    List<Appointment> findByDoctorId(int doctorId);

    // Get all appointments for a patient
    @Query("SELECT a FROM Appointment a WHERE a.patient.id = ?1")
    List<Appointment> findByPatientId(int patientId);
}
