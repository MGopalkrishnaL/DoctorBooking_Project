package com.Geekster.DoctorBooking_Project.service;

import com.Geekster.DoctorBooking_Project.dao.DoctorRepository;
import com.Geekster.DoctorBooking_Project.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository repository;

    public Doctor saveDoctor(Doctor doctor) {
        String doctorName = doctor.getDoctorName();
        doctorName = "Dr. " + doctorName;
        doctor.setDoctorName(doctorName);
        return repository.save(doctor);
    }

    public List<Doctor> getDoctor(String doctorId) {

        List<Doctor> doctorList;

        if(null != doctorId) {
            doctorList = new ArrayList<>();
            doctorList.add(repository.findById(Integer.valueOf(doctorId)).get());
        } else {
            doctorList = (List<Doctor>) repository.findAll();
        }
        return doctorList;
    }

    public Doctor getDoctorById(String doctorId) {

        return repository.findById(Integer.valueOf(doctorId)).get();
    }

    public List<Doctor> experiance() {
        List<Doctor> alldoc = (List<Doctor>) repository.findAll();
        List<Doctor> docByExp = new ArrayList<>();
        for(Doctor doctor : alldoc){
            if(Integer.parseInt(doctor.getExperience())>10){
                docByExp.add(doctor);
            }
        }
        return docByExp;
    }
}