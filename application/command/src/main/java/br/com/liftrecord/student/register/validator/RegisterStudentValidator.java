package br.com.liftrecord.student.register.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.liftrecord.student.register.RegisterStudentCommand;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterStudentValidator extends AbstractValidator<RegisterStudentCommand> {
  @Override
  public void rules() {
    ruleFor(RegisterStudentCommand::accountId)
      .must(Objects::nonNull)
      .withMessage("Account ID is required")
      .withFieldName("accountId")
      .critical();

    ruleFor(RegisterStudentCommand::academyId)
      .must(Objects::nonNull)
      .withMessage("Academy ID is required")
      .withFieldName("academyId")
      .critical();

    ruleFor(RegisterStudentCommand::academyId)
      .must(academyId -> academyId.length() == 26)
      .withMessage("Academy ID must be 26 characters long")
      .withFieldName("academyId")
      .critical();

    ruleFor(RegisterStudentCommand::accountId)
        .must(academyId -> academyId.length() == 26)
        .withMessage("Account ID must be 26 characters long")
        .withFieldName("accountId")
        .critical();

    ruleFor(RegisterStudentCommand::accountId)
        .must(this::studentDoesNotExist)
        .withMessage("This account already has a student")
        .withFieldName("accountId")
        .critical();
  }
}
