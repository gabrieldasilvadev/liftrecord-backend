
package br.com.liftrecord.student.controller.mapper;

import br.com.liftrecord.openapi.model.RegisterStudentRequestDto;
import br.com.liftrecord.openapi.model.RegisterStudentResponseDto;
import br.com.liftrecord.student.register.RegisterStudentCommand;
import br.com.liftrecord.student.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegisterStudentControllerMapper {
  RegisterStudentControllerMapper INSTANCE = Mappers.getMapper(RegisterStudentControllerMapper.class);

  default RegisterStudentCommand toCommand(RegisterStudentRequestDto registerStudentRequestDto) {
    return RegisterStudentCommand.builder()
        .name(registerStudentRequestDto.getName())
        .email(registerStudentRequestDto.getEmail())
        .cellphone(registerStudentRequestDto.getCellphone())
        .state(registerStudentRequestDto.getAddress().getState())
        .city(registerStudentRequestDto.getAddress().getCity())
        .neighborhood(registerStudentRequestDto.getAddress().getNeighborhood())
        .street(registerStudentRequestDto.getAddress().getStreet())
        .number(registerStudentRequestDto.getAddress().getNumber())
        .complement(registerStudentRequestDto.getAddress().getComplement())
        .zipCode(registerStudentRequestDto.getAddress().getZipCode())
        .build();
  }

  default RegisterStudentResponseDto toResponse(Student student) {
    return new RegisterStudentResponseDto()
        .name(student.getName())
        .email(student.getContact().getEmail().getValue())
        .cellphone(student.getContact().getCellphone().getFullNumber())
        .status(student.getStatus().getValue());
  };
}
