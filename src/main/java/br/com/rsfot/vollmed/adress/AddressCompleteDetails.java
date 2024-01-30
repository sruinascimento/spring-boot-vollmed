package br.com.rsfot.vollmed.adress;

public record AddressCompleteDetails(
        Long id,
        String street,
        String neighborhood,
        String city,
        String number,
        String complement,
        String state,
        String zipCode) {

    public AddressCompleteDetails(Address address) {
        this(address.getId(),
                address.getStreet(),
                address.getNeighborhood(),
                address.getCity(),
                address.getNumber(),
                address.getComplement(),
                address.getState(),
                address.getZipCode());
    }
}
