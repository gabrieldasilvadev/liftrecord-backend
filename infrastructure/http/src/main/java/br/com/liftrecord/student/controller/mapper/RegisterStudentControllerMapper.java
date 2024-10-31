
package br.com.liftrecord.student.controller.mapper;

import br.com.liftrecord.openapi.model.RegisterStudentRequestDto;
import br.com.liftrecord.openapi.model.RegisterStudentResponseDto;
import br.com.liftrecord.student.register.RegisterStudentCommand;
import br.com.liftrecord.student.Student;

public class RegisterStudentControllerMapper {

  public static RegisterStudentCommand toCommand(RegisterStudentRequestDto registerStudentRequestDto) {
    return new RegisterStudentCommand(
        registerStudentRequestDto.getName(),
        registerStudentRequestDto.getEmail(),
        registerStudentRequestDto.getCellphone(),
        registerStudentRequestDto.getAddress().getState(),
        registerStudentRequestDto.getAddress().getCity(),
        registerStudentRequestDto.getAddress().getNeighborhood(),
        registerStudentRequestDto.getAddress().getStreet(),
        registerStudentRequestDto.getAddress().getNumber(),
        registerStudentRequestDto.getAddress().getComplement(),
        registerStudentRequestDto.getAddress().getZipCode()
    );
  }

  public static RegisterStudentResponseDto toResponse(Student student) {
    return new RegisterStudentResponseDto()
        .name(student.getName())
        .email(student.getContact().getEmail().getValue())
        .cellphone(student.getContact().getCellphone().getFullNumber())
        .status(student.getAccount().getStatus().name());
  }
}
