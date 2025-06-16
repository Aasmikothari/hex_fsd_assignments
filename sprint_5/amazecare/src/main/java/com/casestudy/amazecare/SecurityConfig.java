package com.casestudy.amazecare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // Allow CORS preflight
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // PUBLIC ENDPOINTS
                .requestMatchers("/api/user/signup").permitAll()
                .requestMatchers("/api/user/token").permitAll()
                .requestMatchers("/api/departments").permitAll()
                .requestMatchers("/api/doctors/department/{deptName}").permitAll()

                // ADMIN ONLY
                .requestMatchers("/api/admin/doctors").hasAuthority("ADMIN")
                .requestMatchers("/api/admin/doctors/{doctorId}").hasAuthority("ADMIN")
                .requestMatchers("/api/admin/patients").hasAuthority("ADMIN")
                .requestMatchers("/api/admin/patients/{patientId}").hasAuthority("ADMIN")
                .requestMatchers("/api/admin/appointments").hasAuthority("ADMIN")

                // DOCTOR ONLY
                .requestMatchers("/api/doctors/user/{userId}").hasAuthority("DOCTOR")
                .requestMatchers("/api/doctors/{doctorId}/appointments/{status}").hasAuthority("DOCTOR")
                .requestMatchers("/api/doctors/{appointmentId}/consultation").hasAuthority("DOCTOR")
                .requestMatchers("/api/doctors/{appointmentId}/prescription").hasAuthority("DOCTOR")
                .requestMatchers("/api/doctors/{appointmentId}/tests").hasAuthority("DOCTOR")

                // PATIENT ONLY
                .requestMatchers("/api/patient/user/{userId}").hasAuthority("PATIENT")
                .requestMatchers("/api/patient/{patientId}/appointments").hasAuthority("PATIENT")
                .requestMatchers("/api/patient/appointments/{appointmentId}/cancel").hasAuthority("PATIENT")
                .requestMatchers("/api/patient/{patientId}/appointments/{status}").hasAuthority("PATIENT")
                .requestMatchers("/api/patient/{patientId}/medical-records").hasAuthority("PATIENT")

                // APPOINTMENT - Shared by all authenticated roles
                .requestMatchers("/api/appointments/{appointmentId}").authenticated()
                .requestMatchers("/api/appointments/{appointmentId}/reschedule").authenticated()
                .requestMatchers("/api/appointments/{appointmentId}/cancel").authenticated()
                .requestMatchers("/api/appointments/status/{status}").authenticated()
                .requestMatchers("/api/appointments/doctor/{doctorId}").authenticated()
                .requestMatchers("/api/appointments/patient/{patientId}").authenticated()

                // CONSULTATION - Doctor Only
                .requestMatchers("/api/consultations/{appointmentId}").hasAuthority("DOCTOR")
                .requestMatchers("/api/consultations/appointment/{appointmentId}").hasAuthority("DOCTOR")
                .requestMatchers("/api/consultations/patient/{patientId}").hasAuthority("DOCTOR")

                // TEST - Doctor Only
                .requestMatchers("/api/tests/appointment/{appointmentId}").hasAuthority("DOCTOR")
                .requestMatchers("/api/tests/status/{status}").hasAuthority("DOCTOR")
                .requestMatchers("/api/tests/{testId}").hasAuthority("DOCTOR")
                .requestMatchers("/api/tests/{appointmentId}").hasAuthority("DOCTOR")

                // PRESCRIPTION - Doctor Only
                .requestMatchers("/api/prescriptions/appointment/{appointmentId}").hasAuthority("DOCTOR")
                .requestMatchers("/api/prescriptions/{appointmentId}").hasAuthority("DOCTOR")

                // MEDICAL RECORD - Doctor & Patient
                .requestMatchers("/api/medical-records/patient/{patientId}").hasAnyAuthority("DOCTOR", "PATIENT")
                .requestMatchers("/api/medical-records/appointment/{appointmentId}").hasAnyAuthority("DOCTOR", "PATIENT")

                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager getAuthManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }
}
