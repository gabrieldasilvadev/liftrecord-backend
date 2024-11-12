package br.com.liftrecord.student;

import br.com.liftrecord.mediator.Mediator;
import br.com.liftrecord.openapi.api.StudentApi;
import br.com.liftrecord.openapi.model.AssignBodyMetricsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentApi {

  private final Mediator mediator;

  @Override
  public ResponseEntity<Void> postApiV1Students() {
    return null;
  }

  @Override
  public ResponseEntity<Void> postApiV1StudentsStudentIdBodyMetrics(String studentId, AssignBodyMetricsRequestDto assignBodyMetricsRequestDto) {
    mediator.execute(AssignBodyMetricsControllerMapper.toCommand(studentId, assignBodyMetricsRequestDto));
    return null;
  }
}
