package br.com.liftrecord.academy;

import br.com.liftrecord.core.Identifier;

public class Academy extends Identifier<String> {
  public Academy(String value) {
    super(value);
  }

  public static Academy fromString(String academyId) {
    return new Academy(academyId);
  }
}
