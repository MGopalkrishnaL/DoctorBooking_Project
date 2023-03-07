package com.Geekster.DoctorBooking_Project.controller;


import com.Geekster.DoctorBooking_Project.dao.DoctorRepository;
import com.Geekster.DoctorBooking_Project.model.Doctor;
import com.Geekster.DoctorBooking_Project.model.Patient;
import com.Geekster.DoctorBooking_Project.service.PatientService;
import com.Geekster.DoctorBooking_Project.utils.CommonUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientService service;

    @PostMapping(value = "/admit-patient")
    public ResponseEntity<String> savePatient(@RequestBody String patientRequest) {

        JSONObject json = new JSONObject(patientRequest);
        List<String> validationList = CommonUtils.validatePatient(json);
        if(validationList.isEmpty()) {
            Patient patient = setPatient(json);
            service.savePatient(patient);
            return new ResponseEntity<>("Patient saved", HttpStatus.CREATED);
        }else {
            String[] answer = Arrays.copyOf(
                    validationList.toArray(), validationList.size(), String[].class);

            return new ResponseEntity<>("Please pass these mandatory parameters- " +
                    Arrays.toString(answer), HttpStatus.BAD_REQUEST);

        }

    }

    private Patient setPatient(JSONObject json) {

        Patient patient = new Patient();


        patient.setPatientId(json.getInt("patientId"));
        patient.setPatientName(json.getString("patientName"));
        patient.setAge(json.getInt("age"));

        patient.setPhoneNumber(json.getString("phoneNumber"));

        patient.setDiseaseType(json.getString("diseaseType"));
        patient.setGender(json.getString("gender"));

        Timestamp currTime = new Timestamp(System.currentTimeMillis());
        patient.setAdmitDate(currTime);

        String doctorId = json.getString("doctorId");
        Doctor doctor = doctorRepository.findById(Integer.valueOf(doctorId)).get();
        patient.setDoctorId(doctor);

        return patient;


    }
    @GetMapping(value = "/get-patient-by-id")
    public List<Patient> getPatientbyid(@RequestParam String patientId, @RequestParam String docterId){

        return this.service.getPatient(patientId,docterId);
    }

}
