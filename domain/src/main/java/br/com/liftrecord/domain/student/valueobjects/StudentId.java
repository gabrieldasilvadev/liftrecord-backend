package br.com.liftrecord.domain.student.valueobjects;

import br.com.liftrecord.domain.core.Identifier;

public class StudentId extends Identifier<String> {
  public StudentId(String value) {
    super(value);
  }
}
