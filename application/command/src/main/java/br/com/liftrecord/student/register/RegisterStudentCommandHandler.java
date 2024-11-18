package br.com.liftrecord.student.register;

import br.com.liftrecord.academy.AcademyId;
import br.com.liftrecord.account.valueobjects.AccountId;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.exception.ObjectStateException;
import br.com.liftrecord.ports.student.StudentRepositoryOutputPort;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.student.register.validator.RegisterStudentValidator;
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
      studentAlreadyExistInAccount(command.accountId());
      final Student student = Student.builder()
          .accountId(new AccountId(command.accountId()))
          .academyId(AcademyId.fromString(command.academyId()))
          .goal(command.goal())
          .medicalConditions(command.medicalConditions())
          .build();
      student.initializeRegister();
      return studentRepositoryOutputPort.save(student);
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

  private void studentAlreadyExistInAccount(String accountId) {
    boolean studentExists = studentRepositoryOutputPort.findByAccountId(AccountId.fromString(accountId)).isPresent();
    if (studentExists) {
      throw new RuntimeException("Student already exist in account");
    }
  }
}
