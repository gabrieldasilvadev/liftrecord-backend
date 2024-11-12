package br.com.liftrecord.valueobjects;

import lombok.Getter;

@Getter
public class Email {
  final String value;
  final String domain;

  public Email(String value) {
    this.value = value;
    domain = value.split("@")[1];
  }

  public static Email fromString(String email) {
    return new Email(email);
  }

  @Override
  public String toString() {
    return "Email{" +
        "value='" + value + '\'' +
        '}';
  }
}
