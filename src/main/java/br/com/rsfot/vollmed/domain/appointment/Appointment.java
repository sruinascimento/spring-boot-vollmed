package br.com.rsfot.vollmed.domain.appointment;

import br.com.rsfot.vollmed.domain.doctor.Doctor;
import br.com.rsfot.vollmed.domain.patient.Patient;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private LocalDateTime date;

    @Deprecated
    public Appointment() {

    }

    public Appointment(Patient patient, Doctor doctor, LocalDateTime date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
