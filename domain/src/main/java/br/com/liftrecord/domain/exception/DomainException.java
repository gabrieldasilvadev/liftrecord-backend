package br.com.liftrecord.domain.exception;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public abstract class DomainException extends RuntimeException implements Serializable {

  @Serial
  private static final long serialVersionUID = -1854946370658874300L;
  private final ErrorMessage message;
  private final List<ErrorMessage> errors;


  protected DomainException(ErrorMessage message, List<ErrorMessage> errors) {
    super(message.getMessage());
    this.message = message;
    this.errors = errors;
  }

  public String getMessage() {
    return message.getMessage();
  }

  public String getDescription() {
    return message.getDescription();
  }

  public List<ErrorMessage> getErrors() {
    return errors;
  }
}
