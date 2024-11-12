package br.com.liftrecord.account.valueobjects;

import br.com.liftrecord.core.Identifier;
import de.huxhorn.sulky.ulid.ULID;

public class AccountId extends Identifier<String> {
  public AccountId(String value) {
    super(value);
  }

  public AccountId() {
    super(new ULID().nextULID());
  }

  public static AccountId fromString(String id) {
    return new AccountId(id);
  }
}
