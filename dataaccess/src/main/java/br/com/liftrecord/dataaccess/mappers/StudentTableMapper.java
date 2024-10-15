package br.com.liftrecord.dataaccess.mappers;

import br.com.liftrecord.dataaccess.tables.StudentTable;
import br.com.liftrecord.domain.student.Student;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentTableMapper {

  StudentTableMapper INSTANCE = Mappers.getMapper(StudentTableMapper.class);

  default StudentTable toTable(Student student) {
    return StudentTable.builder()
        .id(UUID.randomUUID().toString())
        .name(student.getName())
        .email(student.getEmail().getValue())
        .cellphone(student.getCellphone().getFullNumber())
        .build();
  }

  Student toDomain(StudentTable studentSaved);
}
