package br.com.liftrecord.account.valueobjects;

import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class Contact {
  @Nullable
  private final Email email;
  @Nullable
  private final Cellphone cellphone;

  public Contact(String email, String cellphone) {
    this.email = new Email(email);
    this.cellphone = new Cellphone(cellphone);
  }

  @Override
  public String toString() {
    return "Contact{" +
        "email=" + email +
        ", cellphone=" + cellphone +
        '}';
  }
}
