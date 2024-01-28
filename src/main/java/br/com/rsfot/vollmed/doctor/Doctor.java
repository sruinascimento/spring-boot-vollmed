package br.com.rsfot.vollmed.doctor;

import jakarta.persistence.*;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;
    @Enumerated(STRING)
    private Especialty specialty;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
