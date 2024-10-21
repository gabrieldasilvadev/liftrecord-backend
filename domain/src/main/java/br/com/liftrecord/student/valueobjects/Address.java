package br.com.liftrecord.student.valueobjects;

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

  public String getState() {
    return state;
  }

  public String getCity() {
    return city;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public String getStreet() {
    return street;
  }

  public String getNumber() {
    return number;
  }

  public String getComplement() {
    return complement;
  }

  public String getZipCode() {
    return zipCode;
  }
}
