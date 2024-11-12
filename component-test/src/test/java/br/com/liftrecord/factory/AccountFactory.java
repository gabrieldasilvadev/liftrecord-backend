package br.com.liftrecord.factory;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.account.AccountId;
import br.com.liftrecord.student.AccountStatus;
import de.huxhorn.sulky.ulid.ULID;
import java.time.LocalDate;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

public class AccountFactory {
  public static final Model<Account> ACCOUNT_MODEL = Instancio.of(Account.class)
      .generate(field(Account::getId), gen -> gen.oneOf(AccountId.fromString(new ULID().nextULID())))
      .generate(field(Account::getStatus), gen -> gen.enumOf(AccountStatus.class))
      .set(field(Account::getBirthDate), LocalDate.of(1999, 1, 1))
      .setModel(field(Account::getContact), ContactFactory.CONTACT_MODEL)
      .setModel(field(Account::getAddress), AddressFactory.ADDRESS_MODEL)
      .toModel();

  public static Account createAccount() {
    return Instancio.of(ACCOUNT_MODEL)
        .set(field(Account::getStatus), AccountStatus.ACTIVE)
        .create();
  }
}
