package com.meditrack.repository;

import com.meditrack.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    List<Appointment> findByDoctorId(Integer doctorId);

    List<Appointment> findByPatientId(Integer patientId);

    List<Appointment> findByDoctorIdAndAppointmentDateTimeBetween(Integer doctorId, LocalDateTime start, LocalDateTime end);

}
