package com.example.doctor_management.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //It's an entity class representing table inside database
@Table(name = "doctor") //if the name is not specified it'll take the class name as the table name inside the database
public class Doctor {

    @Id // primary key
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int doctorId;

    @Column(name = "doctor_name", nullable = false)
    private String doctorName;

    @Column(name = "doctor_email", nullable = false, unique = true)
    private String email;

    @Column(name = "doctors_designation", nullable = false)
    private String designation;

    @Column(name = "doctors_contact", nullable = false, unique = true)
    private String contactNumber;


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
