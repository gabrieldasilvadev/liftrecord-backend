
package br.com.liftrecord.api.controllers.student.mappers;

import br.com.liftrecord.command.commands.RegisterStudentCommand;
import br.com.liftrecord.contract.model.RegisterStudentRequest;
import br.com.liftrecord.contract.model.RegisterStudentResponse;
import br.com.liftrecord.domain.student.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegisterStudentControllerMapper {
  RegisterStudentControllerMapper INSTANCE = Mappers.getMapper(RegisterStudentControllerMapper.class);

  RegisterStudentCommand toCommand(RegisterStudentRequest registerStudentRequest);

  @Mapping(target = "email", expression = "java(student.getEmail().getValue())")
  @Mapping(target = "cellphone", expression = "java(student.getCellphone().getFullNumber())")
  RegisterStudentResponse toResponse(Student student);
}
