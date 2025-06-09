package com.coding.challenge.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coding.challenge.model.User;
import com.coding.challenge.repository.UserRepository;


@Service
public class UserService { 
	
	// for sign up

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User signUp(User user) {
		String plainPassword = user.getPassword();

		String encodedPassword = passwordEncoder.encode(plainPassword);
		user.setPassword(encodedPassword);

		return userRepository.save(user);
	}

}