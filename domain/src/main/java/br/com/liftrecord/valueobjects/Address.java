package br.com.liftrecord.valueobjects;

public record Address(
    String state,
    String city,
    String neighborhood,
    String street,
    String number,
    String complement,
    String zipCode
) {
}
