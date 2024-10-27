package br.com.liftrecord.student.register.validator;

import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;
import java.io.Serial;
import java.io.Serializable;

public class RegisterStudentValidationException extends ValidationException implements Serializable {

  @Serial
  private static final long serialVersionUID = -7062093650150330658L;

  public RegisterStudentValidationException(ValidationResult validationResult) {
    super(validationResult);
  }
}
