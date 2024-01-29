package br.com.rsfot.vollmed.adress;

import br.com.rsfot.vollmed.doctor.Doctor;
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
        @Pattern(regexp = "\\d{8}", message = "must be in the format XXXXXXXX")
        String zipCode) {
    public Address toModel() {
       return new Address(street, number, neighborhood, city, state, zipCode);
    }

    public void updateAddressFrom(Doctor doctor) {
        if (street != null)
            doctor.getAddress().setStreet(street);

        if (neighborhood != null)
            doctor.getAddress().setNeighborhood(neighborhood);

        if (city != null)
            doctor.getAddress().setCity(city);

        if (number != null)
            doctor.getAddress().setNumber(number);

        if (complement != null)
            doctor.getAddress().setComplement(complement);

        if (state != null)
            doctor.getAddress().setState(state);

        if (zipCode != null)
            doctor.getAddress().setZipCode(zipCode);
    }
}
