package br.com.liftrecord.adapters;

import br.com.liftrecord.account.valueobjects.AccountId;
import br.com.liftrecord.ports.student.StudentRepositoryOutputPort;
import br.com.liftrecord.repositories.StudentRepository;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.tables.StudentTable;
import java.util.Optional;
import lombok.experimental.NonFinal;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
  @Transactional(readOnly = true)
  public Optional<Student> findById(String studentId) {
    return repository.findById(studentId).map(StudentTable::toDomain);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Student> findByAccountId(AccountId accountId) {
    return repository.findById(accountId.getValue()).map(StudentTable::toDomain);
  }
}
