package com.meditrack.mapper;

import com.meditrack.dto.AppointmentRequest;
import com.meditrack.dto.AppointmentResponse;
import com.meditrack.model.Appointment;
import com.meditrack.model.Doctor;
import com.meditrack.model.Patient;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class AppointmentMapper {

    //convert appointmentrequest + patient + doctor into appointment entity

    public Appointment mapToEntity(AppointmentRequest dto, Patient patient, Doctor doctor){
        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(dto.getAppointmentDateTime());
        appointment.setNotes(dto.getNotes());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        return appointment;
    }

    //Converts PPOINTMENT ENTITY INTO APPOINTMENTRESPONSE DTO

    public AppointmentResponse mapToResponse(Appointment appointment){
        AppointmentResponse response = new AppointmentResponse();
        response.setAppointmentId(appointment.getId());

        //Format date for readability
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        response.setAppointmentDateTime(appointment.getAppointmentDateTime().format(formatter));
        response.setStatus(appointment.getStatus().name());
        response.setNotes(appointment.getNotes());

        //Extract patient and doctor info

        response.setPatientName(appointment.getPatient().getFullName());
        response.setDoctorName(appointment.getDoctor().getFullName());
        response.setDoctorSpecialization(appointment.getDoctor().getSpecialization());

        return response;
    }
}
