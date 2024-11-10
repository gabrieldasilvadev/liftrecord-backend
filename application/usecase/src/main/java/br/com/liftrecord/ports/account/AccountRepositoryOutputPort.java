package br.com.liftrecord.ports.account;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.account.valueobjects.Email;
import java.util.Optional;

public interface AccountRepositoryOutputPort {
  Account save(final Account account);

  Optional<Account> findByEmail(Email email);
}
