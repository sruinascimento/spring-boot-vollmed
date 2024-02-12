package br.com.rsfot.vollmed.controller;

import br.com.rsfot.vollmed.domain.appointment.*;
import br.com.rsfot.vollmed.domain.doctor.Doctor;
import br.com.rsfot.vollmed.domain.doctor.DoctorRepository;
import br.com.rsfot.vollmed.domain.patient.Patient;
import br.com.rsfot.vollmed.domain.patient.PatientRepository;
import br.com.rsfot.vollmed.infra.personalized.exception.DoctorNotFoundException;
import br.com.rsfot.vollmed.infra.personalized.exception.PatientNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppointmentController {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentController(DoctorRepository doctorRepository, PatientRepository patientRepository,
                                 AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentCompleteDetails> create(@Valid @RequestBody NewAppointmentRequest newAppointment) {
        Doctor doctor = doctorRepository.findById(newAppointment.doctorId())
                .orElseThrow(() -> new DoctorNotFoundException(newAppointment.doctorId()));

        Patient patient = patientRepository.findById(newAppointment.patientId())
                .orElseThrow(() -> new PatientNotFoundException(newAppointment.patientId()));

        Appointment appointment = new Appointment(patient, doctor, newAppointment.date());
        appointmentRepository.save(appointment);

        return ResponseEntity.ok(new AppointmentCompleteDetails(appointment));
    }
}
