package br.com.liftrecord.student;

import br.com.liftrecord.openapi.api.StudentApi;
import org.springframework.http.ResponseEntity;

public class StudentController implements StudentApi {

  @Override
  public ResponseEntity<Void> postApiV1Students() {
    return null;
  }
}
