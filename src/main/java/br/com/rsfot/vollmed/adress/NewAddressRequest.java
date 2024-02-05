package br.com.rsfot.vollmed.adress;

import br.com.rsfot.vollmed.doctor.Doctor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

import static java.util.Objects.nonNull;

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
        @Pattern(regexp = "\\d{8}", message = "must be in the format XXXXXXXX")
        String zipCode) {
    public Address toModel() {
       return new Address(street, number, neighborhood, city, state, zipCode);
    }

    public void updateAddress(Address address) {
        if (nonNull(street))
            address.setStreet(street);

        if (nonNull(neighborhood))
            address.setNeighborhood(neighborhood);

        if (nonNull(city))
            address.setCity(city);

        if (nonNull(number))
            address.setNumber(number);

        if (nonNull(complement))
            address.setComplement(complement);

        if (nonNull(state))
            address.setState(state);

        if (nonNull(zipCode))
            address.setZipCode(zipCode);
    }
}
