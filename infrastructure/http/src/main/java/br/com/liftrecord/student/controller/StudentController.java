package br.com.liftrecord.student.controller;

import br.com.liftrecord.mediator.Mediator;
import br.com.liftrecord.openapi.api.StudentApi;
import br.com.liftrecord.openapi.model.RegisterStudentRequest;
import br.com.liftrecord.openapi.model.RegisterStudentResponse;
import br.com.liftrecord.student.controller.mapper.RegisterStudentControllerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController implements StudentApi {

  private final Mediator mediator;

  public StudentController(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public ResponseEntity<String> getHello() {
    return ResponseEntity.ok("Hello World!");
  }

  @Override
  public ResponseEntity<RegisterStudentResponse> postStudents(RegisterStudentRequest registerStudentRequest) {
    RegisterStudentControllerMapper mapper = RegisterStudentControllerMapper.INSTANCE;
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(mapper.toResponse(mediator.execute(mapper.toCommand(registerStudentRequest))));
  }
}
