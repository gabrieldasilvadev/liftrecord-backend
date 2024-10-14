package br.com.liftrecord.domain.student.valueobjects;

public class Address {
  final String state;
  final String city;
  final String neighborhood;
  final String street;
  final String number;
  final String complement;
  final String zipCode;

  public Address(String state,
                 String city,
                 String neighborhood,
                 String street,
                 String number,
                 String complement,
                 String zipCode) {
    this.state = state;
    this.city = city;
    this.neighborhood = neighborhood;
    this.street = street;
    this.number = number;
    this.complement = complement;
    this.zipCode = zipCode;
  }
}
