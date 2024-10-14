package br.com.liftrecord.command.commands;

import br.com.liftrecord.command.Command;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public class RegisterStudentCommand extends Command {
  private final String name;
  private final String email;
  private final String cellphone;
  private final String state;
  private final String city;
  private final String neighborhood;
  private final String street;
  private final String number;
  private final String complement;
  private final String zipCode;


  @JsonCreator
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
}
