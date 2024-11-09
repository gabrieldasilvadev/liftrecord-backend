package br.com.liftrecord.student.controller;

import br.com.liftrecord.LogException;
import br.com.liftrecord.mediator.Mediator;
import br.com.liftrecord.openapi.api.StudentApi;
import br.com.liftrecord.openapi.model.RegisterStudentRequestDto;
import br.com.liftrecord.openapi.model.RegisterStudentResponseDto;
import br.com.liftrecord.student.controller.mapper.RegisterStudentControllerMapper;
import br.com.liftrecord.student.inactive.InactiveStudentCommand;
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
  public ResponseEntity<Void> deleteStudentsStudentId(String studentId) {
    mediator.execute(new InactiveStudentCommand(studentId));
    return ResponseEntity.noContent().build();
  }

  @Override
  @LogException
  public ResponseEntity<RegisterStudentResponseDto> postStudents(RegisterStudentRequestDto registerStudentRequest) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(RegisterStudentControllerMapper.toResponse(mediator.execute(RegisterStudentControllerMapper.toCommand(registerStudentRequest))));
  }
}
