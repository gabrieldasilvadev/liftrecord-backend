package br.com.liftrecord.exception;

public class AccountAlreadyExistsException extends RuntimeException {
  public AccountAlreadyExistsException(String message) {
    super(message);
  }
}
