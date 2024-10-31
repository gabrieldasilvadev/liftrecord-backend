package br.com.liftrecord.student.remove;

import br.com.liftrecord.RemoveStudentUseCase;
import br.com.liftrecord.command.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveStudentCommandHandler implements CommandHandler<RemoveStudentCommand, Void> {

  private final RemoveStudentUseCase removeStudentUseCase;

  @Override
  public Void handle(RemoveStudentCommand command) {
    return null;
  }

  @Override
  public Class<RemoveStudentCommand> getCommandType() {
    return RemoveStudentCommand.class;
  }
}
