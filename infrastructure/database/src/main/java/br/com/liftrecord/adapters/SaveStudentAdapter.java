package br.com.liftrecord.adapters;

import br.com.liftrecord.ports.student.SaveStudentOutputPort;
import br.com.liftrecord.repositories.StudentRepository;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.tables.StudentTable;
import lombok.experimental.NonFinal;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class SaveStudentAdapter implements SaveStudentOutputPort {

  private final StudentRepository repository;

  public SaveStudentAdapter(StudentRepository repository) {
    this.repository = repository;
  }

  @Override
  public @NonNull Student save(@NonFinal Student student) {
    StudentTable table = new StudentTable().fromDomain(student);
    repository.save(table);
    return student;
  }
}
