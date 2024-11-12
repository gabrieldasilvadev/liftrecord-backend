package br.com.liftrecord.adapters;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.account.AccountId;
import br.com.liftrecord.account.valueobjects.Email;
import br.com.liftrecord.ports.account.AccountRepositoryOutputPort;
import br.com.liftrecord.repositories.AccountRepository;
import br.com.liftrecord.tables.AccountTable;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepositoryOutputPort {

  private final AccountRepository accountRepository;

  @Override
  public @NonNull Account save(@NonFinal Account account) {
    return accountRepository.save(AccountTable.fromDomain(account)).toDomain();
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsByEmail(Email email) {
    return accountRepository.existsByEmail(email.getValue());
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Account> findByAccountId(AccountId accountId) {
    return accountRepository.findById(accountId.getValue()).map(AccountTable::toDomain);
  }
}
