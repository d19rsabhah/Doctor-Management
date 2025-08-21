package com.example.doctor_management.service;


import com.example.doctor_management.exception.DoctorNotFoundException;
import com.example.doctor_management.model.Doctor;
import com.example.doctor_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service  //it contains business and application logic
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctorRequest){
        // create doct obj
        Doctor doc = new Doctor();
        // take doctreq and add it inside doctor
        doc.setDoctorName(doctorRequest.getDoctorName());
        doc.setEmail(doctorRequest.getEmail());
        doc.setDesignation(doctorRequest.getDesignation());
        doc.setContactNumber(doctorRequest.getContactNumber());
        //now save the doctor
        doc = doctorRepository.save(doc);

        return "Doctor saved successfully";
    }
    public Doctor findDoctorById(int doctorId){
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        Doctor doct = doctorOptional.get();
        return doct;
    }
    public List<Doctor> findAllDoctors(){
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList;
    }
    public Doctor updateDoctor(int doctorId, Doctor updatedDoctor) {
        Doctor existingDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id " + doctorId));

        existingDoctor.setDoctorName(updatedDoctor.getDoctorName());
        existingDoctor.setEmail(updatedDoctor.getEmail());
        existingDoctor.setDesignation(updatedDoctor.getDesignation());
        existingDoctor.setContactNumber(updatedDoctor.getContactNumber());

        return doctorRepository.save(existingDoctor);
    }


}
