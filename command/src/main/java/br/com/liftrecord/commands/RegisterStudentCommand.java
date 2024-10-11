package br.com.liftrecord.commands;

public record RegisterStudentCommand(
    String name,
    String email,
    String cellphone,
    String state,
    String city,
    String neighborhood,
    String street,
    String number,
    String complement,
    String zipCode
) {
}
