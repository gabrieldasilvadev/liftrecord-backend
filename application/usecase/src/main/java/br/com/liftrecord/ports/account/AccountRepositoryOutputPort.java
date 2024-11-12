package br.com.liftrecord.ports.account;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.account.valueobjects.AccountId;
import br.com.liftrecord.valueobjects.Email;
import java.util.Optional;

public interface AccountRepositoryOutputPort {
  Account save(final Account account);

  boolean existsByEmail(Email email);

  Optional<Account> findByAccountId(AccountId accountId);
}
