package br.com.liftrecord.exception;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;

public class DomainException extends RuntimeException implements Serializable {

  @Serial
  private static final long serialVersionUID = -1854946370658874300L;
  private ErrorMessage message;
  @Getter
  private List<ErrorMessage> errors;


  public DomainException(ErrorMessage message, List<ErrorMessage> errors) {
    super(message.getMessage());
    this.message = message;
    this.errors = errors;
  }

  public DomainException(String s) {
    super(s);
  }

  public String getMessage() {
    return message.getMessage();
  }

  public String getDescription() {
    return message.getDescription();
  }
}
