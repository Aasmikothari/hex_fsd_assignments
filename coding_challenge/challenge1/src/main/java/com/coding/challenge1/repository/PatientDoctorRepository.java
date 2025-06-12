package com.coding.challenge1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coding.challenge1.model.Patient;
import com.coding.challenge1.model.PatientDoctor;
import com.coding.challenge1.model.Speciality;

public interface PatientDoctorRepository extends JpaRepository<PatientDoctor, Integer>{
	
	@Query("select pd.patient from PatientDoctor pd where pd.doctor.id=?1")
	List<Patient> getPatientByDoctorId(int doctorId);
	
	@Query("select pd.patient from PatientDoctor pd where pd.doctor.specialization =?1")
	List<Patient> getDoctorBySpeciality(Speciality speciality);

}
