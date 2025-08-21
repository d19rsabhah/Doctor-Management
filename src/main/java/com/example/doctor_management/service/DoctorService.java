package com.example.doctor_management.service;


import com.example.doctor_management.model.Doctor;
import com.example.doctor_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
