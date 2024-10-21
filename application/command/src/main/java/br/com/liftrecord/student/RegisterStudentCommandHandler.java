package br.com.liftrecord.student;

import br.com.liftrecord.SaveStudentUseCase;
import br.com.liftrecord.command.CommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegisterStudentCommandHandler implements CommandHandler<RegisterStudentCommand, Student> {

  private static final Logger logger = LoggerFactory.getLogger(RegisterStudentCommandHandler.class);
  private final SaveStudentUseCase saveStudentUseCase;

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
