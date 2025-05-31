package com.casestudy.amazecare.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.casestudy.amazecare.model.User;
import com.casestudy.amazecare.repository.UserRepository;

@Service
public class UserService {

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