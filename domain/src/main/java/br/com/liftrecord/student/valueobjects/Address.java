package br.com.liftrecord.student.valueobjects;

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
