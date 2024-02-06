package br.com.rsfot.vollmed.domain.adress;

public record NewAddressResponse(
        String street,
        String neighborhood,
        String city,
        String number,
        String complement,
        String state,
        String zipCode) {

    public NewAddressResponse(Address address) {
        this(address.getStreet(),
                address.getNeighborhood(),
                address.getCity(),
                address.getNumber(),
                address.getComplement(),
                address.getState(),
                address.getZipCode());
    }
}
