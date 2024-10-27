package br.com.liftrecord.student.register;

import br.com.liftrecord.Log5WBuilder;
import br.com.liftrecord.student.register.validator.RegisterStudentValidationException;
import br.com.liftrecord.SaveStudentUseCase;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.student.register.validator.RegisterStudentValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegisterStudentCommandHandler implements CommandHandler<RegisterStudentCommand, Student> {

  private static final Logger logger = LoggerFactory.getLogger(RegisterStudentCommandHandler.class);
  private final SaveStudentUseCase saveStudentUseCase;
  private final RegisterStudentValidator registerStudentValidator = new RegisterStudentValidator();

  public RegisterStudentCommandHandler(SaveStudentUseCase saveStudentUseCase) {
    this.saveStudentUseCase = saveStudentUseCase;
  }

  @Override
  public Student handle(final RegisterStudentCommand command) {
    Log5WBuilder
        .method()
        .logCode("RSCH-HDL-001")
        .whatHappen("Register student")
        .addInfo("email", command.getEmail())
        .info(logger);

    registerStudentValidator.validate(command).isInvalidThrow(RegisterStudentValidationException.class);

    final Student student = command.toStudent();
    return saveStudentUseCase.execute(student);
  }

  @Override
  public Class<RegisterStudentCommand> getCommandType() {
    return RegisterStudentCommand.class;
  }
}
