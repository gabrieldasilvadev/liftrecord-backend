package br.com.liftrecord.student.register;

import br.com.liftrecord.command.Command;
import br.com.liftrecord.student.Student;

public class RegisterStudentCommand implements Command {
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

  public RegisterStudentCommand(String name, String email, String cellphone, String state, String city, String neighborhood, String street, String number, String complement, String zipCode) {
    this.name = name;
    this.email = email;
    this.cellphone = cellphone;
    this.state = state;
    this.city = city;
    this.neighborhood = neighborhood;
    this.street = street;
    this.number = number;
    this.complement = complement;
    this.zipCode = zipCode;
  }

  @Override
  public String toString() {
    return "RegisterStudentCommand{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", cellphone='" + cellphone + '\'' +
        ", state='" + state + '\'' +
        ", city='" + city + '\'' +
        ", neighborhood='" + neighborhood + '\'' +
        ", street='" + street + '\'' +
        ", number='" + number + '\'' +
        ", complement='" + complement + '\'' +
        ", zipCode='" + zipCode + '\'' +
        "} " + super.toString();
  }

  public Student toStudent() {
    return new Student(name,
        email,
        cellphone,
        state,
        city,
        neighborhood,
        street,
        number,
        complement,
        zipCode);
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getCellphone() {
    return cellphone;
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
