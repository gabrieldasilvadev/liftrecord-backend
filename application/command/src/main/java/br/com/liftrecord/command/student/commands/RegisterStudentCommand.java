package br.com.liftrecord.command.student.commands;

import br.com.liftrecord.domain.student.Student;
import br.com.liftrecord.domain.student.StudentBuilder;
import br.com.liftrecord.shared.Command;

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


  public RegisterStudentCommand(String name,
                                String email,
                                String cellphone,
                                String state,
                                String city,
                                String neighborhood,
                                String street,
                                String number,
                                String complement,
                                String zipCode) {
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

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setCellphone(String cellphone) {
    this.cellphone = cellphone;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public void setZipCode(String zipCode) {
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
    return new StudentBuilder()
        .setName(this.name)
        .setEmail(this.email)
        .setCellphone(this.cellphone)
        .setState(this.state)
        .setCity(this.city)
        .setNeighborhood(this.neighborhood)
        .setStreet(this.street)
        .setNumber(this.number)
        .setComplement(this.complement)
        .setZipCode(this.zipCode)
        .createStudent();
  }
}
