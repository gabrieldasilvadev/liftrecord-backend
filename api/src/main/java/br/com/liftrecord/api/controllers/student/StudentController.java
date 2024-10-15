package br.com.liftrecord.api.controllers.student;

import br.com.liftrecord.api.controllers.student.mappers.RegisterStudentControllerMapper;
import br.com.liftrecord.contract.api.StudentApi;
import br.com.liftrecord.contract.model.RegisterStudentRequest;
import br.com.liftrecord.contract.model.RegisterStudentResponse;
import br.com.liftrecord.domain.student.Student;
import br.com.liftrecord.shared.mediator.Mediator;
import io.micronaut.http.annotation.Controller;

@Controller
public class StudentController implements StudentApi {

  private final Mediator mediator;

  public StudentController(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public RegisterStudentResponse postStudents(RegisterStudentRequest registerStudentRequest) {
    RegisterStudentControllerMapper mapper = RegisterStudentControllerMapper.INSTANCE;
    final Student student = mediator.execute(mapper.toCommand(registerStudentRequest));
    return mapper.toResponse(student);
  }
}
