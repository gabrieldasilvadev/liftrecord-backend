package br.com.liftrecord;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.account.valueobjects.AccountId;
import br.com.liftrecord.exception.AccountNotFoundException;
import br.com.liftrecord.ports.account.AccountRepositoryOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InactiveAccountUseCase implements UseCase<AccountId, Account> {

  private final AccountRepositoryOutputPort accountRepository;

  @Override
  public Account execute(AccountId input) {
    Account account = accountRepository.findByAccountId(input).orElseThrow(() ->
        new AccountNotFoundException(String.format("Account with id %s not found", input.getValue())));
    account.inactivate();
    return accountRepository.save(account);
  }
}
