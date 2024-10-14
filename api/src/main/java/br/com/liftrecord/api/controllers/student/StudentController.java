package br.com.liftrecord.api.controllers.student;

import br.com.liftrecord.api.controllers.student.mappers.RegisterStudentControllerMapper;
import br.com.liftrecord.command.handlers.RegisterStudentCommandHandler;
import br.com.liftrecord.contract.api.StudentApi;
import br.com.liftrecord.contract.model.RegisterStudentRequest;
import br.com.liftrecord.contract.model.RegisterStudentResponse;
import br.com.liftrecord.domain.student.Student;
import io.micronaut.http.annotation.Controller;

@Controller
public class StudentController implements StudentApi {

  private final RegisterStudentCommandHandler registerStudentCommandHandler;

  public StudentController(RegisterStudentCommandHandler registerStudentCommandHandler) {
    this.registerStudentCommandHandler = registerStudentCommandHandler;
  }

  @Override
  public RegisterStudentResponse postStudents(RegisterStudentRequest registerStudentRequest) {
    RegisterStudentControllerMapper mapper = RegisterStudentControllerMapper.INSTANCE;
    final Student student = registerStudentCommandHandler.doHandle(mapper.toCommand(registerStudentRequest));
    return mapper.toResponse(student);
  }
}
