package br.com.liftrecord.usecase.student.ports;

import br.com.liftrecord.domain.student.Student;

public interface SaveStudentOutputPort {
    Student save(final Student student);
}
