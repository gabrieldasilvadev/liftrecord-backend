package br.com.liftrecord.dataaccess.adapters;

import br.com.liftrecord.dataaccess.mappers.StudentTableMapper;
import br.com.liftrecord.dataaccess.repositories.StudentRepository;
import br.com.liftrecord.dataaccess.tables.StudentTable;
import br.com.liftrecord.domain.student.Student;
import br.com.liftrecord.usecase.student.ports.SaveStudentOutputPort;
import io.micronaut.context.annotation.Context;
import io.micronaut.core.annotation.NonNull;
import java.util.UUID;

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
