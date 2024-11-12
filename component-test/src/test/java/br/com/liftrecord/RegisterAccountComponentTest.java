package br.com.liftrecord;

import br.com.liftrecord.utils.JsonReaderUtil;
import io.restassured.http.ContentType;
import java.util.Arrays;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasLength;

class RegisterAccountComponentTest extends BaseComponentTest {

  @Test
  @DisplayName("Given a valid request, When POST /api/v1/accounts, Then return status 201 (CREATED) Account registered")
  void testRegisterStatus() {
    String jsonRequest = JsonReaderUtil.readJsonRequest("post-register-student-status-200.json");
    given()
        .body(jsonRequest)
        .contentType(ContentType.JSON)
        .when()
        .post("/api/v1/accounts")
        .then()
        .statusCode(HttpStatus.SC_CREATED)
        .body("name", equalTo("name_bbaa851b2153"))
        .body("email", equalTo("emailexample@gmail.com"))
        .body("status", containsStringIgnoringCase("pending_activation"))
        .body("account_id", hasLength(26))
        .body("birth_date", equalTo("2000-01-01"));
  }

  @Test
  @DisplayName("Given a valid request, When POST /api/v1/accounts, Then return status 400 (Bad Request) invalid Email pattern")
  void testRegisterInvalidEmailPattern() {
    String jsonRequest = JsonReaderUtil.readJsonRequest("post-register-student-invalid-email-pattern-status-400.json");
    given()
        .body(jsonRequest)
        .contentType(ContentType.JSON)
        .when()
        .post("/api/v1/accounts")
        .then()
        .statusCode(HttpStatus.SC_BAD_REQUEST)
        .body("message", containsStringIgnoringCase("Email pattern is invalid"))
        .body("status", equalTo("BAD_REQUEST"));
  }
}