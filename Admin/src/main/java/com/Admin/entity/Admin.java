package com.Admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;

    private String email;
    private String password;

    // Default constructor
    public Admin() {
    }

    // Parameterized constructor
    public Admin(Integer employee_id, String email, String password) {
        this.employee_id = employee_id;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
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

    @Override
    public String toString() {
        return "Admin{" +
                "employee_id=" + employee_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
