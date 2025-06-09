package com.coding.challenge.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.coding.challenge.model.User;
import com.coding.challenge.service.UserService;
import com.coding.challenge.util.JwtUtil;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;

	/*
	 * AIM: Insert a new user in DB with encrypted password.
	 * PATH: /api/user/signup
	 * METHOD: POST
	 * RETURN: User with encoded password
	 */
	@PostMapping("/signup")
	public User signUp(@RequestBody User user) {
		return userService.signUp(user);
	}
	
	/*
     * AIM    : Generate JWT token after login
     * METHOD : GET
     * PATH   : /api/user/token
     * AUTH   : Basic Authentication required
     * RESPONSE : JWT token string
     */
	@GetMapping("/token")
	public ResponseEntity<?> getToken(Principal principal) {
		try {
		String token =jwtUtil.createToken(principal.getName()); 
		return ResponseEntity.status(HttpStatus.OK).body(token);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
}
