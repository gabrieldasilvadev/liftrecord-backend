package br.com.liftrecord.account.inactive;

import br.com.liftrecord.InactiveAccountUseCase;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.exception.ObjectStateException;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.account.inactive.validator.InactiveStudentValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InactiveStudentCommandHandler implements CommandHandler<InactiveStudentCommand, Student> {

  private final InactiveAccountUseCase inactiveAccountUseCase;
  private final InactiveStudentValidator inactiveStudentValidator;

  @Override
  public Student handle(InactiveStudentCommand command) {
    inactiveStudentValidator.validate(command).isInvalidThrow(ObjectStateException.class);
    inactiveAccountUseCase.execute(command.studentId());
    return null;
  }

  @Override
  public Class<InactiveStudentCommand> getCommandType() {
    return InactiveStudentCommand.class;
  }
}
