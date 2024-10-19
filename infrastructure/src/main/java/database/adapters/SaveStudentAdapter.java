package database.adapters;

import br.com.liftrecord.student.ports.SaveStudentOutputPort;
import database.mappers.StudentTableMapper;
import database.repositories.StudentRepository;
import database.tables.StudentTable;
import br.com.liftrecord.domain.student.Student;
import io.micronaut.context.annotation.Context;
import io.micronaut.core.annotation.NonNull;

@Context
public class SaveStudentAdapter implements SaveStudentOutputPort {

  private final StudentRepository repository;

  public SaveStudentAdapter(StudentRepository repository) {
    this.repository = repository;
  }

  @Override
  public @NonNull Student save(final Student student) {
    StudentTable table = StudentTableMapper.INSTANCE.toTable(student);
    repository.save(table);
    return student;
  }
}
