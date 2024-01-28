package br.com.rsfot.vollmed.doctor;

import br.com.rsfot.vollmed.adress.NewAddressRequest;
import jakarta.validation.constraints.*;

public record NewDoctorRequest(
        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}", message = "must be in the format XXXX or XXXXXX" )
        String crm,
        @NotBlank
        Especialty specialty,
        @NotNull
        NewAddressRequest address) {
    public Doctor toModel() {
        return new Doctor(name, email, phone, crm, specialty, address.toModel());
    }
}
