package com.meditrack.dto;


public class AppointmentResponse {

    private int appointmentId;
    private String appointmentDateTime;
    private String status;
    private String notes;
    private String patientName;
    private String doctorName;
    private String doctorSpecialization;

    public AppointmentResponse() {
    }

    public AppointmentResponse(int appointmentId, String appointmentDateTime, String status, String notes, String patientName, String doctorName, String doctorSpecialization) {
        this.appointmentId = appointmentId;
        this.appointmentDateTime = appointmentDateTime;
        this.status = status;
        this.notes = notes;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.doctorSpecialization = doctorSpecialization;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(String appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }
}
