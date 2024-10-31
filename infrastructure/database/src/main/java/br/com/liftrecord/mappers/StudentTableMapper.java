package br.com.liftrecord.mappers;

import br.com.liftrecord.student.Student;
import br.com.liftrecord.tables.AccountTable;
import br.com.liftrecord.tables.StudentTable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentTableMapper {

  StudentTableMapper INSTANCE = Mappers.getMapper(StudentTableMapper.class);

  default StudentTable toTable(Student student) {
    return StudentTable.builder()
        .id(student.getId().getValue())
        .account(new AccountTable(student.getAccount()))
        .build();
  }
}
