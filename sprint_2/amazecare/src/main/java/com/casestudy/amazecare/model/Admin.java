package com.casestudy.amazecare.model;

import jakarta.persistence.*;

/**
 * This class represents an Admin user in the AmazeCare system.
 * Admins are responsible for managing doctors, patients, and appointments.
 */

@Entity
@Table(name = "admin")
public class Admin {

    // Primary key for the admin table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
