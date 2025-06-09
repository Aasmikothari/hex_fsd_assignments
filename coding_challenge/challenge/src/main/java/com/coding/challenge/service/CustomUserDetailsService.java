package com.coding.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.coding.challenge.model.User;
import com.coding.challenge.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	// for authentication
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole());
		List<GrantedAuthority> authorities = List.of(authority);

		return new org.springframework.security.core.userdetails.User(
			user.getUsername(),
			user.getPassword(),
			authorities
		);
	}
}