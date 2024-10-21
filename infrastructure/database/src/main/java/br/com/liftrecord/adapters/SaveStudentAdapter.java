package br.com.liftrecord.adapters;

import br.com.liftrecord.mappers.StudentTableMapper;
import br.com.liftrecord.ports.SaveStudentOutputPort;
import br.com.liftrecord.repositories.StudentRepository;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.tables.StudentTable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
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
