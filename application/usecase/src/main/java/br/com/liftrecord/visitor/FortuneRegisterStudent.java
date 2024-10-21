package br.com.liftrecord.visitor;

import br.com.liftrecord.student.Student;
import org.springframework.stereotype.Component;

@Component
public class FortuneRegisterStudent implements Visitor<Student, Student> {

  @Override
  public Student visit(Student domainObject) {
    domainObject.initializeStudent();
    return domainObject;
  }
}
