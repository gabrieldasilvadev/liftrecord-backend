package br.com.liftrecord.student.valueobjects;

public class Contact {
  private final Email email;
  private final Cellphone cellphone;

  public Contact(Email email, Cellphone cellphone) {
    this.email = email;
    this.cellphone = cellphone;
  }

  public Email getEmail() {
    return email;
  }

  public Cellphone getCellphone() {
    return cellphone;
  }
}
