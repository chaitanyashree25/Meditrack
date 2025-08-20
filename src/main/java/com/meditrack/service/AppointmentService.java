package com.meditrack.service;

import com.meditrack.dto.AppointmentRequest;
import com.meditrack.dto.AppointmentResponse;
import com.meditrack.mapper.AppointmentMapper;
import com.meditrack.model.Appointment;
import com.meditrack.model.Doctor;
import com.meditrack.model.Patient;
import com.meditrack.repository.AppointmentRepository;
import com.meditrack.repository.DoctorRepository;
import com.meditrack.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, AppointmentMapper appointmentMapper){
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentMapper = appointmentMapper;
    }

    public AppointmentResponse saveAppointment(AppointmentRequest request){
        //Step 1 - lookup Patient
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with Id: " +request.getPatientId()));
        //Step 2 - lookup Doctor
        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with Id : " +request.getDoctorId()));

        //Step 3 - Convert DTO to Entity using mapper
        Appointment appointment = appointmentMapper.mapToEntity(request,patient,doctor);

        //Steo 4 - Save the appointment
        Appointment savedAppointment = appointmentRepository.save(appointment);

        //Strp 5 - Convert saed entity to Response DTO
        return appointmentMapper.mapToResponse(savedAppointment);
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
