package br.com.liftrecord.student.inactive;

import br.com.liftrecord.InactiveAccountUseCase;
import br.com.liftrecord.command.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InactiveStudentCommandHandler implements CommandHandler<InactiveStudentCommand, Void> {

  private final InactiveAccountUseCase inactiveAccountUseCase;


  @Override
  public Void handle(InactiveStudentCommand command) {
    return inactiveAccountUseCase.execute(command.studentId());
  }

  @Override
  public Class<InactiveStudentCommand> getCommandType() {
    return InactiveStudentCommand.class;
  }
}
