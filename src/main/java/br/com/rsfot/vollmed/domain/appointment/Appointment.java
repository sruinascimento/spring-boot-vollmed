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
    @Column(name = "date_appointment")
    private LocalDateTime dateAppointment;

    @Deprecated
    public Appointment() {

    }

    public Appointment(Patient patient, Doctor doctor, LocalDateTime dateAppointment) {
        this.patient = patient;
        this.doctor = doctor;
        this.dateAppointment = dateAppointment;
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

    public LocalDateTime getDateAppointment() {
        return dateAppointment;
    }
}
