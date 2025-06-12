package com.coding.challenge1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.challenge1.model.Doctor;
import com.coding.challenge1.model.User;
import com.coding.challenge1.repository.DoctorRepository;

@Service
public class DoctorService {
	
	private DoctorRepository doctorRepository;
	
	@Autowired
	private UserService userService;
	
	public DoctorService(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}
	
	//add doctor with user
	public Doctor add(Doctor doctor) {
		User user=doctor.getUser();
		user.setRole("DOCTOR");
		user=userService.signUp(user);
		doctor.setUser(user);
		return doctorRepository.save(doctor);
	}

}
