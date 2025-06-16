package com.casestudy.amazecare.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.casestudy.amazecare.model.User;
import com.casestudy.amazecare.service.UserService;
import com.casestudy.amazecare.util.JwtUtil;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    /*
     * AIM    : Insert new user with encrypted password
     * METHOD : POST
     * PATH   : /api/user/signup
     * RESPONSE : User object
     */
    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return userService.signUp(user);
    }

    /*
     * AIM    : Generate JWT Token and return User Role
     * METHOD : GET
     * PATH   : /api/user/token
     * RESPONSE : JWT Token string + User Role
     */
    @GetMapping("/token")
    public ResponseEntity<?> getToken(Principal principal) {
        try {
            String token = jwtUtil.createToken(principal.getName());

            // Get user details from DB
            User user = userService.getUserByUsername(principal.getName());

            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            map.put("role", user.getRole()); // Adding role here

            return ResponseEntity.status(HttpStatus.OK).body(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    /*
     * AIM    : Get logged-in user details (Admin/Doctor/Patient)
     * METHOD : GET
     * PATH   : /api/user/details
     * RESPONSE : Respective role-specific object
     */
    @GetMapping("/details")
    public Object getLoggedInUserDetails(Principal principal) {
        String username = principal.getName(); // Get logged-in username
        return userService.getUserInfo(username);
    }
}