package com.meditrack.controller;

import com.meditrack.model.Patient;
import com.meditrack.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;


    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping
    public Patient savePatient(@Valid @RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

    @GetMapping("/by-email")
    public Optional<Patient> getEmailByEmail(@RequestParam String email){
        return patientService.getPatientByEmail(email);
    }
}
