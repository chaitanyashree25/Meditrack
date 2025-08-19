package com.meditrack.controller;

import com.meditrack.model.Doctor;
import com.meditrack.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PostMapping
    public Doctor saveDoctor(@Valid @RequestBody Doctor doctor){
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping("/by-specialization")
    public List<Doctor> getBySpecialization(@RequestParam String specialization){
        return doctorService.getBySpecialization(specialization);
    }
}
