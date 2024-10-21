package br.com.liftrecord;

import br.com.liftrecord.ports.SaveStudentOutputPort;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.visitor.FortuneRegisterStudent;
import org.springframework.stereotype.Service;

@Service
public class SaveStudentUseCase implements UseCase<Student, Student> {

  private final SaveStudentOutputPort saveStudentOutputPort;
  private final FortuneRegisterStudent fortuneRegisterStudent;

  public SaveStudentUseCase(FortuneRegisterStudent fortuneRegisterStudent, SaveStudentOutputPort saveStudentOutputPort) {
    this.saveStudentOutputPort = saveStudentOutputPort;
    this.fortuneRegisterStudent = fortuneRegisterStudent;
  }

  @Override
  public Student execute(Student input) {
    final Student student = fortuneRegisterStudent.visit(input);
    saveStudentOutputPort.save(student);
    return student;
  }
}
