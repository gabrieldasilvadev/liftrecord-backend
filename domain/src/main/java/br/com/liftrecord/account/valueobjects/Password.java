package br.com.liftrecord.account.valueobjects;

public record Password(String password) {

  @Override
  public String toString() {
    return "Password{" +
        "password='" + password + '\'' +
        '}';
  }
}
