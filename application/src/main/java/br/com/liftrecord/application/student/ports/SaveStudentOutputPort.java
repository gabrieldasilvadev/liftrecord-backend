package br.com.liftrecord.application.student.ports;

import br.com.liftrecord.domain.student.Student;

public interface SaveStudentOutputPort {
    Student save(final Student student);
}
