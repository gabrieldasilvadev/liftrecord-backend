package br.com.liftrecord.usecase.student;

import br.com.liftrecord.domain.student.Student;
import br.com.liftrecord.usecase.UseCase;
import br.com.liftrecord.usecase.student.ports.SaveStudentOutputPort;
import br.com.liftrecord.usecase.student.visitor.FortuneRegisterStudent;
import jakarta.inject.Singleton;

@Singleton
public class SaveStudentUseCase implements UseCase<Student, Student> {

  private final SaveStudentOutputPort saveStudentOutputPort;
  private final FortuneRegisterStudent fortuneRegisterStudent;

  public SaveStudentUseCase(SaveStudentOutputPort saveStudentOutputPort, FortuneRegisterStudent fortuneRegisterStudent) {
    this.saveStudentOutputPort = saveStudentOutputPort;
    this.fortuneRegisterStudent = fortuneRegisterStudent;
  }

  @Override
  public Student execute(Student input) {
    final Student student = fortuneRegisterStudent.visit(input);
    return saveStudentOutputPort.save(student);
  }
}
