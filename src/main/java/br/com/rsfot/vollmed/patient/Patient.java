package br.com.rsfot.vollmed.patient;

import br.com.rsfot.vollmed.adress.Address;
import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false, unique = true)
    private String cpf;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "address_id")
    private Address address;
    private boolean active = true;

    @Deprecated
    public Patient() {

    }

    public Patient(String name, String email, String phone, String cpf, Address address, boolean active) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
        this.address = address;
        this.active = active;
    }

    public Patient(String name, String email, String phone, String cpf, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
        this.address = address;
    }

    public Long getId() {
        return id;
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

    public String getCpf() {
        return cpf;
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
