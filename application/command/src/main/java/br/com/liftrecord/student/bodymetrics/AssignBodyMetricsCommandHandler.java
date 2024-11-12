package br.com.liftrecord.student.bodymetrics;

import br.com.liftrecord.AssignBodyMetricsUseCase;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.exception.ObjectStateException;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.student.bodymetrics.validator.AssignBodyMetricsValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignBodyMetricsCommandHandler implements CommandHandler<AssignBodyMetricsCommand, Student> {
  private final AssignBodyMetricsValidator  assignBodyMetricsValidator;
  private final AssignBodyMetricsUseCase assignBodyMetricsUseCase;

  @Override
  public Student handle(@Valid AssignBodyMetricsCommand command) {
    assignBodyMetricsValidator.validate(command).isInvalidThrow(ObjectStateException.class);
    assignBodyMetricsUseCase.execute(command.toTransient());
    return null;
  }

  @Override
  public Class<AssignBodyMetricsCommand> getCommandType() {
    return AssignBodyMetricsCommand.class;
  }

  @Override
  public boolean canHandle(AssignBodyMetricsCommand command) {
    return command.studentId().length() == 26;
  }
}
