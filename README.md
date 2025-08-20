MediTrack — Healthcare Appointments & Records (Spring Boot)

A Spring Boot backend for managing doctors, patients, and appointments with robust validation, layered architecture, and clean REST APIs. Ideal as a production-style portfolio project demonstrating domain modeling, DTOs, and testing.

✨ Features

Create & manage Patients, Doctors, Appointments

Validation using Jakarta Validation (e.g., @FutureOrPresent for appointment time)

Layered architecture (Controller → Service → Repository → Entity/DTO)

Global exception handling & consistent API error responses

Pagination & sorting endpoints (where relevant)

Environment-based configs (H2 for dev, MySQL/PostgreSQL for prod)

Unit & integration tests (JUnit 5, Mockito, Spring Boot Test)

Note: This README assumes the common Spring Boot structure visible in the repo (src, pom.xml) and your earlier MediTrack DTOs (e.g., AppointmentRequest). Adjust the entity/field names to match your code. 
GitHub

🧱 Tech Stack

Language: Java (17+)

Framework: Spring Boot 3.x (Web, Validation, Data JPA)

Database: H2 (dev) / MySQL or PostgreSQL (prod)

Build: Maven

Testing: JUnit 5, Mockito, Spring Boot Test

Tools (optional): Lombok, MapStruct, Testcontainers

📁 Project Structure
MediTrack/
├─ src/
│  ├─ main/
│  │  ├─ java/com/yourorg/meditrack/
│  │  │  ├─ controller/
│  │  │  ├─ service/
│  │  │  ├─ repository/
│  │  │  ├─ model/        # Entities
│  │  │  ├─ dto/          # e.g., AppointmentRequest
│  │  │  └─ exception/    # GlobalExceptionHandler, ApiError
│  │  └─ resources/
│  │     ├─ application.yml
│  │     └─ data.sql / schema.sql (optional)
│  └─ test/java/...        # unit & integration tests
├─ pom.xml
└─ README.md


Confirm package names and adjust paths to your actual code.

🔌 API (Sample Design)

Replace with your exact paths/fields once you confirm from controllers.

Patients

POST /api/patients – create patient

GET /api/patients/{id} – get patient by id

GET /api/patients – list (pagination page, size, sort)

PUT /api/patients/{id} – update patient

DELETE /api/patients/{id} – soft/hard delete

Doctors

POST /api/doctors – create doctor

GET /api/doctors/{id} – get doctor

GET /api/doctors – list/search by specialization

PUT /api/doctors/{id} – update

DELETE /api/doctors/{id} – delete

Appointments

POST /api/appointments – create (validates future/present time)

Body (example):

{
  "appointmentDateTime": "2025-08-25T15:30:00",
  "patientId": 101,
  "doctorId": 12,
  "notes": "Follow-up visit"
}


GET /api/appointments/{id} – get by id

GET /api/appointments – list by patient/doctor/date filters

PUT /api/appointments/{id} – reschedule/update notes

DELETE /api/appointments/{id} – cancel

Validation examples

@FutureOrPresent on appointmentDateTime

@NotNull, @Positive on patientId / doctorId

@Size(max = 1000) for notes
