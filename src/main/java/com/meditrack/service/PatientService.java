package com.meditrack.service;

import com.meditrack.model.Patient;
import com.meditrack.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientByEmail(String email){
        return patientRepository.findByEmail(email);
    }
}
