package br.com.liftrecord.exception;

import br.com.liftrecord.account.Account;
import lombok.Getter;

@Getter
public class AccountAlreadyExistsException extends RuntimeException {
  private Account account;
  public AccountAlreadyExistsException(String message, Account account) {
    super(message);
    this.account = account;
  }
}
