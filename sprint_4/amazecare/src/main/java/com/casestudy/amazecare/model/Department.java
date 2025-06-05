package com.casestudy.amazecare.model;

import jakarta.persistence.*;

/**
 * This class represents the Department entity in the system.
 * Each department can have many doctors associated with it.
 * We are modeling a many-to-one relationship from Doctor to Department.
 */

@Entity
@Table(name = "department")
public class Department {

    // Primary key of the department table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Name of the department, e.g., "Cardiology", "Orthopedics"
    private String name;

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

}
