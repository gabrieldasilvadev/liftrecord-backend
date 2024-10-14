package br.com.liftrecord.dataaccess.adapters;

import br.com.liftrecord.dataaccess.mappers.StudentTableMapper;
import br.com.liftrecord.dataaccess.repositories.StudentRepository;
import br.com.liftrecord.dataaccess.tables.StudentTable;
import br.com.liftrecord.domain.student.Student;
import br.com.liftrecord.usecase.student.ports.SaveStudentOutputPort;
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
    final StudentTable studentSaved = repository.save(StudentTableMapper.INSTANCE.toTable(student));
    return StudentTableMapper.INSTANCE.toDomain(studentSaved);
  }
}
