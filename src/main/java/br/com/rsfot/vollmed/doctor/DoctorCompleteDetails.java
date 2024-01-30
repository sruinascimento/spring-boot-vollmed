package br.com.rsfot.vollmed.doctor;

import br.com.rsfot.vollmed.adress.AddressCompleteDetails;

public record DoctorCompleteDetails(
        Long id,
        String name,
        String email,
        String phone,
        String crm,
        Especialty specialty,
        AddressCompleteDetails address) {

public DoctorCompleteDetails(Doctor doctor) {
        this(doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getPhone(),
                doctor.getCrm(),
                doctor.getSpecialty(),
                new AddressCompleteDetails(doctor.getAddress()));
    }
}
