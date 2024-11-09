package br.com.liftrecord.adapters;

import br.com.liftrecord.ports.student.StudentRepositoryOutputPort;
import br.com.liftrecord.repositories.StudentRepository;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.tables.StudentTable;
import java.util.Optional;
import lombok.experimental.NonFinal;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StudentRepositoryAdapter implements StudentRepositoryOutputPort {

  private final StudentRepository repository;

  public StudentRepositoryAdapter(StudentRepository repository) {
    this.repository = repository;
  }

  @Override
  public @NonNull Student save(@NonFinal Student student) {
    final StudentTable table = new StudentTable().fromDomain(student);
    repository.save(table);
    return student;
  }

  @Override
  public Optional<Student> findById(String studentId) {
    return repository.findById(studentId).map(StudentTable::toDomain);
  }
}
