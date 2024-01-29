package br.com.rsfot.vollmed.doctor;

import br.com.rsfot.vollmed.adress.NewAddressRequest;
import jakarta.validation.Valid;

public record UpdateDoctorRequest(
        String name,
        String phone,
        @Valid
        NewAddressRequest newAddressRequest) {

    public void updateDoctor(Doctor doctor) {
        if (name != null)
            doctor.setName(name);

        if (phone != null)
            doctor.setPhone(phone);

        if (newAddressRequest != null)
            newAddressRequest.updateAddressFrom(doctor);
    }
}
