package br.com.rsfot.vollmed.domain.patient;

import br.com.rsfot.vollmed.domain.adress.NewAddressRequest;
import jakarta.validation.Valid;

import static java.util.Objects.nonNull;

public record UpdatePatientRequest(
        String name,
        String phone,
        @Valid
        NewAddressRequest newAddressRequest) {

    public void updatePatient(Patient patient) {
        if (nonNull(name))
            patient.setName(name);

        if (nonNull(phone))
            patient.setPhone(phone);

        if (nonNull(newAddressRequest))
            newAddressRequest.updateAddress(patient.getAddress());
    }
}
