package br.com.liftrecord;

import br.com.liftrecord.ports.student.StudentRepositoryOutputPort;
import br.com.liftrecord.student.Student;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaveStudentUseCase implements UseCase<Student, Student> {

  private final StudentRepositoryOutputPort studentRepositoryOutputPort;

  @Override
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public @NonNull Student execute(@NonFinal Student input) {
    input.registerStudent();
    return studentRepositoryOutputPort.save(input);
  }
}
