package com.casestudy.amazecare.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.casestudy.amazecare.model.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {

    // Get all medical records by patient ID
    @Query("SELECT m FROM MedicalRecord m WHERE m.patient.id = ?1")
    List<MedicalRecord> findByPatientId(int patientId);

    // Get medical record by appointment ID
    @Query("SELECT m FROM MedicalRecord m WHERE m.appointment.id = ?1")
    MedicalRecord findByAppointmentId(int appointmentId);
    
    //Find all medical records for a doctor's appointments
    @Query("SELECT mr FROM MedicalRecord mr WHERE mr.appointment.doctor.id = :doctorId")
    List<MedicalRecord> findAllByDoctorId(int doctorId);
}