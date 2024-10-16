package br.com.liftrecord;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import br.com.liftrecord.utils.JsonReader;

import static io.restassured.RestAssured.given;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ComponentTestContext {

  @BeforeEach
  void setUp() {
    RestAssured.port = 7050;
  }

  @Test
  @DisplayName("Test that the application context can be retrieved from the embedded server")
  void testItWorks() {
//    EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);
//    server.start();
//    RegisterStudentRequest registerStudentRequestStub = Instancio.create(RegisterStudentRequest.class);
//    String objectToJsonRequest = new GsonBuilder().setPrettyPrinting().create().toJson(registerStudentRequestStub);
    String jsonRequest = JsonReader.readJsonRequest("post-register-student-status-200.json");

    given()
        .body(jsonRequest)
        .contentType("application/json")
        .when()
        .post("/students")
        .then()
        .statusCode(200);

//    server.stop();
  }
}