package br.com.rsfot.vollmed.doctor;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
}
