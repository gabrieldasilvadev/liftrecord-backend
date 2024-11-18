package br.com.liftrecord.academy;

import br.com.liftrecord.core.Identifier;

public class AcademyId extends Identifier<String> {
  public AcademyId(String value) {
    super(value);
  }

  public static AcademyId fromString(String academyId) {
    return new AcademyId(academyId);
  }
}
