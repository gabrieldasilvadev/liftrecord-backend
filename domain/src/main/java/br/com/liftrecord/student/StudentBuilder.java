package br.com.liftrecord.student;

public class StudentBuilder {
  private String name;
  private String email;
  private String cellphone;
  private String state;
  private String city;
  private String neighborhood;
  private String street;
  private String number;
  private String complement;
  private String zipCode;

  public StudentBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public StudentBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public StudentBuilder setCellphone(String cellphone) {
    this.cellphone = cellphone;
    return this;
  }

  public StudentBuilder setState(String state) {
    this.state = state;
    return this;
  }

  public StudentBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public StudentBuilder setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
    return this;
  }

  public StudentBuilder setStreet(String street) {
    this.street = street;
    return this;
  }

  public StudentBuilder setNumber(String number) {
    this.number = number;
    return this;
  }

  public StudentBuilder setComplement(String complement) {
    this.complement = complement;
    return this;
  }

  public StudentBuilder setZipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  public Student createStudent() {
    return new Student(name, email, cellphone, state, city, neighborhood, street, number, complement, zipCode);
  }
}