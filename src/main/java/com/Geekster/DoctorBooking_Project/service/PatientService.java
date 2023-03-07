package com.Geekster.DoctorBooking_Project.service;


import com.Geekster.DoctorBooking_Project.dao.PatientRepository;
import com.Geekster.DoctorBooking_Project.model.Doctor;
import com.Geekster.DoctorBooking_Project.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository repository;

    public void savePatient(Patient patient) {
        repository.save(patient);
    }

    public List<Patient> getPatient(String patientId, String docterId){
        List<Patient> patientsList = new ArrayList<>();
        Patient patient = repository.findById(Integer.valueOf(patientId)).get();
        Doctor doctor = patient.getDoctorId();
        if (doctor.getDoctorId() == Integer.parseInt(docterId)) {
            patientsList.add(patient);
        }
        return patientsList;
    }
}