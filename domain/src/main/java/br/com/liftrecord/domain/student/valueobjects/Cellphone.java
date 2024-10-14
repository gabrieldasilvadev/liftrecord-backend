package br.com.liftrecord.domain.student.valueobjects;

public class Cellphone {
  final String ddd;
  final String number;

  public Cellphone(String ddd, String number) {
    this.ddd = ddd;
    this.number = number;
  }

  public Cellphone(String fullNumber) {
    ddd = fullNumber.substring(0, 2);
    number = fullNumber.substring(2);
  }

  public String getFullNumber() {
    return ddd + number;
  }
}
