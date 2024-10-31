package br.com.liftrecord.ports.student;

import br.com.liftrecord.student.Student;

public interface SaveStudentOutputPort {
    Student save(final Student student);
}
