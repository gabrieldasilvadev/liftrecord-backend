package br.com.liftrecord.usecase.student;

import br.com.liftrecord.domain.student.Student;
import br.com.liftrecord.usecase.UseCase;
import br.com.liftrecord.usecase.student.ports.SaveStudentOutputPort;
import jakarta.inject.Singleton;

@Singleton
public class SaveStudentUseCase implements UseCase<Student, Student> {

  private final SaveStudentOutputPort saveStudentOutputPort;

  public SaveStudentUseCase(SaveStudentOutputPort saveStudentOutputPort) {
    this.saveStudentOutputPort = saveStudentOutputPort;
  }

  @Override
  public Student execute(Student input) {
    return saveStudentOutputPort.save(input);
  }
}
