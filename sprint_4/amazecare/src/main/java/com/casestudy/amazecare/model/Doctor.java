package com.casestudy.amazecare.model;

import jakarta.persistence.*;

/**
 * This class represents a Doctor in the AmazeCare system.
 * Each doctor belongs to a single department (Many Doctors → One Department).
 */

@Entity
@Table(name = "doctor")
public class Doctor {

    // Primary key for the doctor table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String contact;
    private String qualification;
    private String designation;
    private int experience;
    private String password;

    // Many doctors can belong to one department
    @ManyToOne
    @JoinColumn(name = "department_id")  // foreign key column in doctor table
    private Department department;
    
    @OneToOne
    private User user; 

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    

}