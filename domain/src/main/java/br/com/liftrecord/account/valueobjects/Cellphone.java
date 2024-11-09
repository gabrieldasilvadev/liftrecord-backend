package br.com.liftrecord.account.valueobjects;

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

  public static Cellphone fromFullNumberString(String cellphone) {
    return new Cellphone(cellphone);
  }

  public String getFullNumber() {
    return ddd + number;
  }

  @Override
  public String toString() {
    return "Cellphone{" +
        "number='" + getFullNumber() + '\'' +
        '}';
  }
}
