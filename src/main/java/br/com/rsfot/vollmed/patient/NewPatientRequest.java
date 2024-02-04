package br.com.rsfot.vollmed.patient;

import br.com.rsfot.vollmed.adress.Address;
import br.com.rsfot.vollmed.adress.NewAddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record NewPatientRequest(
        @NotBlank(message = "{name.not.blank}")
        String name,
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        @Pattern(regexp = "\\d{11}", message = "{cpf.invalid.format}")
        String cpf,
        @Valid
        NewAddressRequest address
) {
    public Patient toModel() {
        return new Patient(name, email, phone, cpf, address.toModel());
    }
}
