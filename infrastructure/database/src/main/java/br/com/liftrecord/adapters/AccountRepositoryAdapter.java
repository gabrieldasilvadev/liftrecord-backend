package br.com.liftrecord.adapters;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.ports.account.AccountRepositoryOutputPort;
import br.com.liftrecord.repositories.AccountRepository;
import br.com.liftrecord.tables.AccountTable;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepositoryOutputPort {

  private final AccountRepository accountRepository;

  @Override
  public @NonNull Account save(@NonFinal Account account) {
    return accountRepository.save(new AccountTable(account)).toDomain();
  }
}
