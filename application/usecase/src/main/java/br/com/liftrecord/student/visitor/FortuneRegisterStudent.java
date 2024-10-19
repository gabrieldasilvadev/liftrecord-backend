package br.com.liftrecord.student.visitor;

import br.com.liftrecord.domain.student.Student;
import br.com.liftrecord.domain.visitor.Visitor;

public class FortuneRegisterStudent implements Visitor<Student, Student> {

  @Override
  public Student visit(Student domainObject) {
    domainObject.initializeStudent();
    return domainObject;
  }
}
