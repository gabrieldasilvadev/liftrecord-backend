package br.com.liftrecord.ports;

import br.com.liftrecord.student.Student;

public interface SaveStudentOutputPort {
    Student save(final Student student);
}
