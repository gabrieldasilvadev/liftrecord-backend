package br.com.liftrecord.command.handlers;

import br.com.liftrecord.command.commands.RegisterStudentCommand;
import br.com.liftrecord.domain.student.Student;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.usecase.student.SaveStudentUseCase;
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
    Student student = new Student(command.getName(), command.getEmail(), command.getCellphone());
    return saveStudentUseCase.execute(student);
  }
}
