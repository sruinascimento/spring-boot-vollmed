package br.com.rsfot.vollmed.adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record NewAddressRequest(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        String city,
        String number,
        String complement,
        @NotBlank
        String state,
        @NotBlank
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "must be in the format XXXXX-XXX")
        String zipCode) {
    public Address toModel() {
       return new Address(street, number, neighborhood, city, state, zipCode);
    }
}
