package com.casestudy.amazecare.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.casestudy.amazecare.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

    // Get tests by appointment ID
    @Query("SELECT t FROM Test t WHERE t.appointment.id = ?1")
    List<Test> findByAppointmentId(int appointmentId);

    // Get tests by status
    @Query("SELECT t FROM Test t WHERE t.status = ?1")
    List<Test> findByStatus(String status);
}