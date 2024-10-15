package br.com.liftrecord.api.mappers;

import br.com.liftrecord.api.controllers.student.mappers.RegisterStudentControllerMapper;
import br.com.liftrecord.command.student.commands.RegisterStudentCommand;
import br.com.liftrecord.contract.model.RegisterStudentRequest;
import br.com.liftrecord.contract.model.RegisterStudentResponse;
import br.com.liftrecord.domain.student.Student;
import de.huxhorn.sulky.ulid.ULID;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RegisterStudentControllerMapperTest {

  private final RegisterStudentControllerMapper mapper = RegisterStudentControllerMapper.INSTANCE;

  @Test
  @DisplayName("Should map Student to RegisterStudentResponse")
  void shouldMapStudentToRegisterStudentResponse() {
    Student student = Instancio.create(Student.class);

    RegisterStudentResponse response = mapper.toResponse(student);

    assertNotNull(response);
    assertEquals(student.getName(), response.getName());
    assertEquals(student.getEmail().getValue(), response.getEmail());
    assertEquals(student.getCellphone().getFullNumber(), response.getCellphone());
  }

  @Test
  @DisplayName("Should map RegisterStudentRequest to RegisterStudentCommand")
  void shouldMapRegisterStudentRequestToRegisterStudentCommand() {
    RegisterStudentRequest request = Instancio.create(RegisterStudentRequest.class);

    RegisterStudentCommand command = mapper.toCommand(request);

    assertNotNull(command);
    assertEquals(request.getName(), command.getName());
    assertEquals(request.getEmail(), command.getEmail());
    assertEquals(request.getCellphone(), command.getCellphone());
  }
}
