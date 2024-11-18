package br.com.liftrecord.ports.student;

import br.com.liftrecord.account.valueobjects.AccountId;
import br.com.liftrecord.student.Student;
import java.util.Optional;

public interface StudentRepositoryOutputPort {
    Student save(final Student student);

    Optional<Student> findById(String studentId);

    Optional<Student> findByAccountId(AccountId accountId);
}
