package br.com.liftrecord.student.valueobjects;

import br.com.liftrecord.core.Identifier;
import de.huxhorn.sulky.ulid.ULID;

public class StudentId extends Identifier<String> {
  public StudentId(String value) {
    super(value);
  }

  public StudentId() {
    super(new ULID().nextULID());
  }

  public static StudentId fromString(String studentId) {
    return new StudentId(studentId);
  }
}
