package database.mappers;

import database.tables.StudentTable;
import br.com.liftrecord.domain.student.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentTableMapper {

  StudentTableMapper INSTANCE = Mappers.getMapper(StudentTableMapper.class);

  default StudentTable toTable(Student student) {
    return StudentTable.builder()
        .id(student.getId().getValue())
        .name(student.getName())
        .email(student.getContact().getEmail().getValue())
        .cellphone(student.getContact().getCellphone().getFullNumber())
        .address(AddressTableMapper.INSTANCE.toTable(student.getAddress()))
        .status(student.getStatus())
        .build();
  }
}
