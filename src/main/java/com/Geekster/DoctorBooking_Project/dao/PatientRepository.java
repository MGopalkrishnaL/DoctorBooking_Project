package com.Geekster.DoctorBooking_Project.dao;

import com.Geekster.DoctorBooking_Project.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}