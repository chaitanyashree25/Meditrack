package com.meditrack.controller;

import com.meditrack.model.Appointment;
import com.meditrack.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public Appointment saveAppointment(@Valid @RequestBody Appointment appointment){
        return appointmentService.saveAppointment(appointment);
    }

    @GetMapping("/by-doctor/{doctorId}")
    public List<Appointment> getByDoctor(@PathVariable Integer doctorId){
        return appointmentService.getByDoctor(doctorId);
    }

    @GetMapping("/by-patient/{patientId}")
    public List<Appointment> getByPatient(@PathVariable Integer patientId){
        return appointmentService.getByPatient(patientId);
    }

    @GetMapping("/appointment-by-doctor")
    public List<Appointment> getDoctorAppointmentsInRange(@RequestParam Integer doctorId,@Valid LocalDateTime start,@Valid LocalDateTime end){
        return appointmentService.getDoctorAppointmentsInRange(doctorId,start,end);
    }
}
