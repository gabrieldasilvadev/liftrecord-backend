
package br.com.liftrecord.student.controller.mapper;

import br.com.liftrecord.openapi.model.RegisterStudentRequest;
import br.com.liftrecord.openapi.model.RegisterStudentResponse;
import br.com.liftrecord.student.register.RegisterStudentCommand;
import br.com.liftrecord.student.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegisterStudentControllerMapper {
  RegisterStudentControllerMapper INSTANCE = Mappers.getMapper(RegisterStudentControllerMapper.class);

  default RegisterStudentCommand toCommand(RegisterStudentRequest registerStudentRequest) {
    return new RegisterStudentCommand(
        registerStudentRequest.getName(),
        registerStudentRequest.getEmail(),
        registerStudentRequest.getCellphone(),
        registerStudentRequest.getAddress().getState(),
        registerStudentRequest.getAddress().getCity(),
        registerStudentRequest.getAddress().getNeighborhood(),
        registerStudentRequest.getAddress().getStreet(),
        registerStudentRequest.getAddress().getNumber(),
        registerStudentRequest.getAddress().getComplement(),
        registerStudentRequest.getAddress().getZipCode()
    );
  }

  default RegisterStudentResponse toResponse(Student student) {
    return new RegisterStudentResponse()
        .name(student.getName())
        .email(student.getContact().getEmail().getValue())
        .cellphone(student.getContact().getCellphone().getFullNumber())
        .status(student.getStatus().getValue());
  };
}
