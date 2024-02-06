package br.com.rsfot.vollmed.domain.doctor;

import br.com.rsfot.vollmed.domain.adress.NewAddressResponse;

public record NewDoctorResponse(
        String name,
        String email,
        String phone,
        String crm,
        Especialty specialty,
        NewAddressResponse address) {

    public NewDoctorResponse(Doctor doctor) {
        this(doctor.getName(),
                doctor.getEmail(),
                doctor.getPhone(),
                doctor.getCrm(),
                doctor.getSpecialty(),
                new NewAddressResponse(doctor.getAddress()));
    }
}
