package br.com.liftrecord.student.register;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.account.valueobjects.AccountId;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.exception.ObjectStateException;
import br.com.liftrecord.ports.student.StudentRepositoryOutputPort;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.student.register.validator.RegisterStudentValidator;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterStudentCommandHandler implements CommandHandler<RegisterStudentCommand, Student> {
  private final StudentRepositoryOutputPort studentRepositoryOutputPort;
  private final RegisterStudentValidator registerStudentValidator;

  @Override
  public Student handle(RegisterStudentCommand command) {
    registerStudentValidator.validate(command).isInvalidThrow(ObjectStateException.class);
    try {
      Account account = studentRepositoryOutputPort.findByAccountId(AccountId.fromString(command.accountId()))
          .orElseThrow(() -> new RuntimeException("Account not found"))
          .getAccount();

      studentAlreadyExistInAccount(account);
      return Student.register(
          account,
          null,
          command.goal(),
          command.medicalConditions()
      );
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Class<RegisterStudentCommand> getCommandType() {
    return RegisterStudentCommand.class;
  }

  @Override
  public boolean canHandle(RegisterStudentCommand command) {
    return command.accountId() != null && command.academyId() != null;
  }

  private void studentAlreadyExistInAccount(Account account) {
    boolean studentExists = Objects.nonNull(account.getStudentId());
    if (studentExists) {
      throw new RuntimeException("Student already exist in account");
    }
  }
}
