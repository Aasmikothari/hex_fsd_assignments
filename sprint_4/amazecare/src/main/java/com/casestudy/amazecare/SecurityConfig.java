package com.casestudy.amazecare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration //<- This ensures that this class gets called during every API call
public class SecurityConfig {
	@Autowired
	private JwtFilter jwtFilter;
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf((csrf) -> csrf.disable()) 
			.authorizeHttpRequests(auth -> auth
				    // everyone can access
				    .requestMatchers("/api/user/signup").permitAll()
				    .requestMatchers("/api/user/token").authenticated()
				    .requestMatchers("/api/user/details").authenticated()
				    .requestMatchers("/api/department/get-all").permitAll()

				    // admin access
				    .requestMatchers("/api/department/add").hasAuthority("ADMIN")
				    .requestMatchers("/api/department/update/**").hasAuthority("ADMIN")
				    .requestMatchers("/api/department/delete/**").hasAuthority("ADMIN")
				    .requestMatchers("/api/doctor/add").hasAuthority("ADMIN")
				    .requestMatchers("/api/doctor/delete/**").hasAuthority("ADMIN")
				    .requestMatchers("/api/patient/get-all").hasAuthority("ADMIN")

				    // doctor access
				    .requestMatchers("/api/consultation/add").hasAuthority("DOCTOR")
				    .requestMatchers("/api/prescription/add").hasAuthority("DOCTOR")
				    .requestMatchers("/api/test/add").hasAuthority("DOCTOR")
				    .requestMatchers("/api/medical-record/add").hasAuthority("DOCTOR")

				    // patient access
				    .requestMatchers("/api/appointment/schedule").hasAuthority("PATIENT")
				    .requestMatchers("/api/patient/add").hasAuthority("PATIENT")
				    .requestMatchers("/api/patient/update/**").hasAuthority("PATIENT")
				    .requestMatchers("/api/patient/delete/**").hasAuthority("PATIENT")

				    // access with admin, doctor, patient
				    .requestMatchers("/api/doctor/get-all").hasAnyAuthority("ADMIN", "DOCTOR", "PATIENT")
				    .requestMatchers("/api/appointment/view").hasAnyAuthority("ADMIN", "DOCTOR", "PATIENT")
				    .requestMatchers("/api/consultation/view").hasAnyAuthority("ADMIN", "DOCTOR", "PATIENT")
				    .requestMatchers("/api/prescription/view").hasAnyAuthority("ADMIN", "DOCTOR", "PATIENT")
				    .requestMatchers("/api/test/view").hasAnyAuthority("ADMIN", "DOCTOR", "PATIENT")
				    .requestMatchers("/api/medical-record/view").hasAnyAuthority("ADMIN", "DOCTOR", "PATIENT")
				    .requestMatchers("/api/patient/get-one/**").hasAnyAuthority("ADMIN", "DOCTOR", "PATIENT")
				    .requestMatchers("/api/doctor/update/**").hasAnyAuthority("ADMIN", "DOCTOR", "PATIENT")

				    // Any other APIs must be authenticated
				    .anyRequest().authenticated()
				)
			
		 .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) 
		 .httpBasic(Customizer.withDefaults()); //<- this activated http basic technique
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {  //<- Bean saves this object in spring's context
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager getAuthManager(AuthenticationConfiguration auth) 
			throws Exception {
		  return auth.getAuthenticationManager();
	 }
}