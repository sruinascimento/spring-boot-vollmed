package br.com.rsfot.vollmed.domain.doctor;

import br.com.rsfot.vollmed.domain.adress.Address;
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
    @Column(nullable = false)
    private boolean active = true;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public boolean isActive() {
        return active;
    }
    public void inactivate() {
        this.active = false;
    }
}
