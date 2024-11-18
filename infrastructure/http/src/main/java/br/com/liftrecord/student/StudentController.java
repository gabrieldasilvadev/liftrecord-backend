package br.com.liftrecord.student;

import br.com.liftrecord.mediator.Mediator;
import br.com.liftrecord.openapi.api.StudentApi;
import br.com.liftrecord.openapi.model.AssignBodyMetricsRequestDto;
import br.com.liftrecord.openapi.model.AssignBodyMetricsResponseDto;
import br.com.liftrecord.openapi.model.RegisterStudentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentApi {

  private final Mediator mediator;

  @Override
  public ResponseEntity<Void> postApiV1Students(RegisterStudentRequestDto registerStudentRequestDto) {
    mediator.execute(RegisterStudentControllerMapper.toCommand(registerStudentRequestDto));
    return null;
  }

  @Override
  public ResponseEntity<AssignBodyMetricsResponseDto> postApiV1StudentsStudentIdBodyMetrics(String studentId, AssignBodyMetricsRequestDto assignBodyMetricsRequestDto) {
    Student student = mediator.execute(AssignBodyMetricsControllerMapper.toCommand(studentId, assignBodyMetricsRequestDto));
    return ResponseEntity.status(HttpStatus.CREATED).body(AssignBodyMetricsControllerMapper.toResponse(student));
  }
}
