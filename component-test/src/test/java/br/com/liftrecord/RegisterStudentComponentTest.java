package br.com.liftrecord;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.liftrecord.utils.JsonReader;

import static io.restassured.RestAssured.given;

public class RegisterStudentComponentTest extends BaseComponentTest {

  @Test
  @DisplayName("Given a valid request, When POST /students, Then return status 200 (OK) Student registered")
  void testRegisterStatus() {
    String jsonRequest = JsonReader.readJsonRequest("post-register-student-status-200.json");

    given()
        .body(jsonRequest)
        .contentType("application/json")
        .when()
        .post("/students")
        .then()
        .statusCode(200)
        .log().all();
  }
}