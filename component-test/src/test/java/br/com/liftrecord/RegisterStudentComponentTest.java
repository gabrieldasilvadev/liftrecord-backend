package br.com.liftrecord;

import io.micronaut.http.HttpStatus;
import br.com.liftrecord.utils.JsonReaderUtil;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterStudentComponentTest extends BaseComponentTest {

  @Test
  @DisplayName("Given a valid request, When POST /students, Then return status 200 (OK) Student registered")
  public void testRegisterStatus() {
    String jsonRequest = JsonReaderUtil.readJsonRequest("post-register-student-status-200.json");

    given()
        .body(jsonRequest)
        .contentType("application/json")
        .when()
        .post("/students")
        .then()
        .statusCode(HttpStatus.CREATED.getCode())
        .log().all()
        .body("name", equalTo("name_bbaa851b2153"))
        .body("email", equalTo("emailexample@gmail.com"))
        .body("status", equalTo("pending_activation"));
  }
}