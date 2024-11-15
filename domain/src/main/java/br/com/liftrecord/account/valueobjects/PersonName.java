package br.com.liftrecord.account.valueobjects;

import lombok.Getter;

@Getter
public class PersonName {
  private final String firstName;
  private final String lastName;

  public PersonName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public PersonName(String fullName) {
    this(fullName.split(" ")[0], fullName.split(" ")[1]);
  }

  public String fullName() {
    return firstName + " " + lastName;
  }

  public static PersonName from(String firstName, String lastName) {
    return new PersonName(firstName, lastName);
  }
}
