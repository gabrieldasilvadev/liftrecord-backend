package br.com.liftrecord.student.valueobjects;

public class Email {
  final String value;
  final String domain;

  public Email(String value) {
    this.value = value;
    domain = value.split("@")[1];
  }

  public String getValue() {
    return value;
  }

  public String getDomain() {
    return domain;
  }
}
