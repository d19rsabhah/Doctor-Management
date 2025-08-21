package com.example.doctor_management.controller;

import com.example.doctor_management.model.Doctor;
import com.example.doctor_management.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/doctor/api")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctorRequest){
        String response = doctorService.addDoctor(doctorRequest);
        return response;
    }

    @GetMapping("/get/{doctorId}")
    public Doctor findDoctorById(@PathVariable("doctorId") int doctorId){
        Doctor result = doctorService.findDoctorById(doctorId);
        return result;
    }

    @GetMapping("/getAll")
    public List<Doctor> finadAllDoctors(){
        return doctorService.findAllDoctors();
    }

//    @PutMapping("/update/{doctorId}")
//    public ResponseEntity<Doctor> updateDoctor(@PathVariable("doctorId") int doctorId, @RequestBody Doctor doctorRequest){
//        Doctor updateDoctor = doctorService.updateDoctor(doctorId, doctorRequest);
//        return ResponseEntity.ok(updateDoctor);
//    }

    @PutMapping("/doctors/{doctorId}")
    public ResponseEntity<?> updateDoctor(@PathVariable("doctorId") int doctorId, @RequestBody Doctor doctorRequest) {
        try {
            Doctor updatedDoctor = doctorService.updateDoctor(doctorId, doctorRequest);
            return ResponseEntity.ok(updatedDoctor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
