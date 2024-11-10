package br.com.liftrecord.student.inactive.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.liftrecord.student.inactive.InactiveStudentCommand;
import org.springframework.stereotype.Component;

@Component
public class InactiveStudentValidator extends AbstractValidator<InactiveStudentCommand> {
  @Override
  public void rules() {
    ruleFor(InactiveStudentCommand::studentId)
        .must(studentId -> !studentId.isBlank())
        .when(String::isBlank)
        .withCode("STUDENT_ID_IS_BLANK")
        .withMessage("StudentId cannot be blank")
        .withFieldName("studentId")
        .critical();
  }
}
