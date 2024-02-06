package br.com.rsfot.vollmed.domain.patient;

import br.com.rsfot.vollmed.domain.adress.AddressCompleteDetails;

public record PatientCompleteDetails(
        Long id,
        String name,
        String email,
        String phone,
        String cpf,
        AddressCompleteDetails address) {

    public PatientCompleteDetails(Patient patient) {
        this(patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getCpf(),
                new AddressCompleteDetails(patient.getAddress())
        );
    }
}
