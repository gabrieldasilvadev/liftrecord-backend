package br.com.liftrecord.adapters;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.ports.account.SaveAccountOutputPort;
import br.com.liftrecord.repositories.AccountRepository;
import br.com.liftrecord.tables.AccountTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveAccountAdapter implements SaveAccountOutputPort{

  private final AccountRepository accountRepository;

  @Override
  public Account save(Account account) {
    return accountRepository.save(new AccountTable(account)).toDomain();
  }
}
