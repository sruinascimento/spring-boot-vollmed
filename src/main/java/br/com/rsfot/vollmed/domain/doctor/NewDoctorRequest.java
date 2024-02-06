package br.com.rsfot.vollmed.domain.doctor;

import br.com.rsfot.vollmed.domain.adress.NewAddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record NewDoctorRequest(
        @NotBlank(message = "{name.not.blank}")
        String name,
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}", message = "must be in the format XXXX or XXXXXX" )
        String crm,
        @NotNull
        Especialty specialty,
        @Valid
        NewAddressRequest address) {
    public Doctor toModel() {
        return new Doctor(name, email, phone, crm, specialty, address.toModel());
    }
}
