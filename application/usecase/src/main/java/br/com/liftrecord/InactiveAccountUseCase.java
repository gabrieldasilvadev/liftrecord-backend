package br.com.liftrecord;

import br.com.liftrecord.ports.account.AccountRepositoryOutputPort;
import br.com.liftrecord.ports.account.InactiveAccountOutputPort;
import br.com.liftrecord.ports.student.StudentRepositoryOutputPort;
import br.com.liftrecord.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InactiveAccountUseCase implements UseCase<String, Student> {

  private final StudentRepositoryOutputPort studentRepository;
  private final AccountRepositoryOutputPort accountRepository;
//  private final InactiveAccountOutputPort inactiveAccountOutputPort;

  @Override
  public Student execute(String input) {
    Student student = studentRepository.findById(input).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    student.inactivateAccount();
    accountRepository.save(student.getAccount());
    return null;
  }
}
