package br.com.liftrecord.student.register;

import br.com.liftrecord.CreateAccountUseCase;
import br.com.liftrecord.Log5WBuilder;
import br.com.liftrecord.account.Account;
import br.com.liftrecord.student.register.validator.RegisterStudentValidationException;
import br.com.liftrecord.SaveStudentUseCase;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.student.register.validator.RegisterStudentValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterStudentCommandHandler implements CommandHandler<RegisterStudentCommand, Student> {

  private static final Logger logger = LoggerFactory.getLogger(RegisterStudentCommandHandler.class);
  private final SaveStudentUseCase saveStudentUseCase;
  private final CreateAccountUseCase createAccountUseCase;
  private final RegisterStudentValidator registerStudentValidator;

  @Override
  public Student handle(@Valid final RegisterStudentCommand command) {
    Log5WBuilder
        .method()
        .logCode("RSCH-HDL-001")
        .whatHappen("Starting student registration flow")
        .addInfo("REGISTER_STUDENT_COMMAND_DATA", command.toString())
        .info(logger);

    registerStudentValidator.validate(command).isInvalidThrow(RegisterStudentValidationException.class);
    final Student studentFromCommand = command.toStudent();
    final Account accountFromCommand = command.toAccount();
    final Account newAccount = createAccountUseCase.execute(accountFromCommand);
    studentFromCommand.assignAccount(newAccount);
    Student newStudent = saveStudentUseCase.execute(studentFromCommand);

    Log5WBuilder
        .method()
        .logCode("RSCH-HDL-002")
        .whatHappen("Student registered successfully")
        .addInfo("ACCOUNT_DATA", newAccount.toString())
        .addInfo("STUDENT_DATA", newStudent.toString())
        .info(logger);

    return newStudent;
  }

  @Override
  public Class<RegisterStudentCommand> getCommandType() {
    return RegisterStudentCommand.class;
  }
}
