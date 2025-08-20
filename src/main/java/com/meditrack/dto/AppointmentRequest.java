package com.meditrack.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class AppointmentRequest {

    @NotNull
    @FutureOrPresent
    private LocalDateTime appointmentDateTime;
    @NotNull
    @Positive
    private int patientId;
    @Positive
    @NotNull
    private int doctorId;
    @Size(max = 1000)
    private String notes;

    public AppointmentRequest() {
    }

    public AppointmentRequest(LocalDateTime appointmentDateTime, int patientId, int doctorId, String notes) {
        this.appointmentDateTime = appointmentDateTime;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.notes = notes;
    }

    public @NotNull @FutureOrPresent LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(@NotNull @FutureOrPresent LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    @NotNull
    @Positive
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(@NotNull @Positive int patientId) {
        this.patientId = patientId;
    }

    @Positive
    @NotNull
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(@Positive @NotNull int doctorId) {
        this.doctorId = doctorId;
    }

    public @Size(max = 1000) String getNotes() {
        return notes;
    }

    public void setNotes(@Size(max = 1000) String notes) {
        this.notes = notes;
    }
}
