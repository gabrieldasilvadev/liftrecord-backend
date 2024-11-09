package br.com.liftrecord;

import br.com.liftrecord.ports.student.StudentRepositoryOutputPort;
import br.com.liftrecord.student.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveStudentUseCase implements UseCase<Student, Student> {

  private final StudentRepositoryOutputPort studentRepositoryOutputPort;

  @Override
  public Student execute(Student input) {
    input.registerStudent();
    return studentRepositoryOutputPort.save(input);
  }
}
