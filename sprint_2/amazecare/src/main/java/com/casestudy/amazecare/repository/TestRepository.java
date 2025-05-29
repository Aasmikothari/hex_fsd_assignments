package com.casestudy.amazecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.casestudy.amazecare.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

    List<Test> findByPatientId(int patientId);
}
