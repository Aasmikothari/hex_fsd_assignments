package com.casestudy.amazecare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.casestudy.amazecare.model.User;
import com.casestudy.amazecare.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
		List<GrantedAuthority> authorities = List.of(authority);

		return new org.springframework.security.core.userdetails.User(
			user.getUsername(),
			user.getPassword(),
			authorities
		);
	}
}