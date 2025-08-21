package com.example.doctor_management.repository;


import com.example.doctor_management.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //It performs the Database related operations

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
