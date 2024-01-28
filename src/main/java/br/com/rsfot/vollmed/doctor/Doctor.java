package br.com.rsfot.vollmed.doctor;

import br.com.rsfot.vollmed.adress.Address;
import jakarta.persistence.*;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false, unique = true)
    private String crm;
    @Enumerated(STRING)
    private Especialty specialty;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "address_id")
    private Address address;

    @Deprecated
    public Doctor() {
    }

    public Doctor(String name, String email, String phone, String crm, Especialty specialty, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.crm = crm;
        this.specialty = specialty;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCrm() {
        return crm;
    }

    public Especialty getSpecialty() {
        return specialty;
    }

    public Address getAddress() {
        return address;
    }
}
