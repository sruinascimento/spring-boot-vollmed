package br.com.rsfot.vollmed.domain.patient;

public record PatientResponse(String name, String email, String cpf) {

    public PatientResponse(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
