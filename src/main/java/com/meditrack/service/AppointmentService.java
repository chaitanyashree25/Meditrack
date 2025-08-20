package com.meditrack.service;

import com.meditrack.model.Appointment;
import com.meditrack.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment saveAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getByDoctor(Integer doctorId){
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getByPatient(Integer patientId){
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getDoctorAppointmentsInRange(Integer doctorId, LocalDateTime start, LocalDateTime end){
        return appointmentRepository.findByDoctorIdAndAppointmentDateTimeBetween(doctorId,start,end);
    }
}
