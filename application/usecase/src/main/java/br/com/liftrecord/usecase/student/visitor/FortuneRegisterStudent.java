package br.com.liftrecord.usecase.student.visitor;

import br.com.liftrecord.domain.student.Student;
import br.com.liftrecord.domain.visitor.Visitor;
import jakarta.inject.Singleton;

@Singleton
public class FortuneRegisterStudent implements Visitor<Student, Student> {

  @Override
  public Student visit(Student domainObject) {
    domainObject.initializeStudent();
    return domainObject;
  }
}
