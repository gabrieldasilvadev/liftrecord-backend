package br.com.liftrecord;

import br.com.liftrecord.student.Student;
import org.springframework.stereotype.Service;

@Service
public class RemoveStudentUseCase implements UseCase<String, Student> {

//  private final RemoveStudentByIdOutputPort removeStudentByIdOutputPort;

  @Override
  public Student execute(String input) {
    return null;
  }
}
