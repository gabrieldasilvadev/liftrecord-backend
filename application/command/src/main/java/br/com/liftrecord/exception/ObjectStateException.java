package br.com.liftrecord.exception;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;
import java.io.Serial;
import java.io.Serializable;

public class ObjectStateException extends ValidationException implements Serializable {

  @Serial
  private static final long serialVersionUID = -5259239049611725137L;

  public ObjectStateException(ValidationResult validationResult) {
    super(validationResult);
  }
}
