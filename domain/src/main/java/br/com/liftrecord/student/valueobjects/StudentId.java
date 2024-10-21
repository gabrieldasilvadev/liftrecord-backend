package br.com.liftrecord.student.valueobjects;

import br.com.liftrecord.core.Identifier;

public class StudentId extends Identifier<String> {
  public StudentId(String value) {
    super(value);
  }
}
