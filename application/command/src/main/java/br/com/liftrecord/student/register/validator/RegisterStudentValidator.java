package br.com.liftrecord.student.register.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.PredicateBuilder;
import br.com.liftrecord.student.register.RegisterStudentCommand;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class RegisterStudentValidator extends AbstractValidator<RegisterStudentCommand> {

  private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
  Pattern pattern = Pattern.compile(EMAIL_REGEX);

  @Override
  public void rules() {

    ruleFor(RegisterStudentCommand::getName)
        .must(name -> !name.isEmpty())
        .when(String::isBlank)
        .withCode("NAME_IS_BLANK")
        .withMessage("Name cannot be blank")
        .withFieldName("name")
        .critical();

    ruleFor(RegisterStudentCommand::getEmail)
        .must(PredicateBuilder.<String>from(email -> email != null && pattern.matcher(email).matches()))
        .withCode("EMAIL_PATTERN_INVALID")
        .withMessage("Email pattern is invalid")
        .withFieldName("email")
        .critical();
  }
}
