package com.Geekster.DoctorBooking_Project.dao;

import com.Geekster.DoctorBooking_Project.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
