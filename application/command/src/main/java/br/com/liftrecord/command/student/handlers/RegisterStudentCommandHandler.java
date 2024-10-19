package br.com.liftrecord.command.student.handlers;

import br.com.liftrecord.command.student.commands.RegisterStudentCommand;
import br.com.liftrecord.domain.student.Student;
import br.com.liftrecord.shared.CommandHandler;
import br.com.liftrecord.student.SaveStudentUseCase;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class RegisterStudentCommandHandler implements CommandHandler<RegisterStudentCommand, Student> {

  private static final Logger logger = LoggerFactory.getLogger(RegisterStudentCommandHandler.class);
  private final SaveStudentUseCase saveStudentUseCase;

  @Inject
  public RegisterStudentCommandHandler(SaveStudentUseCase saveStudentUseCase) {
    this.saveStudentUseCase = saveStudentUseCase;
  }

  @Override
  public Student handle(final RegisterStudentCommand command) {
    logger.info("RegisterStudentCommandHandler.handle: {}", command);
    final Student student = command.toStudent();
    return saveStudentUseCase.execute(student);
  }

  @Override
  public Class<RegisterStudentCommand> getCommandType() {
    return RegisterStudentCommand.class;
  }
}
