package br.com.liftrecord;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.ports.account.AccountRepositoryOutputPort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAccountUseCase implements UseCase<Account, Account>{

  private final AccountRepositoryOutputPort accountRepositoryOutputPort;

  @Override
  public @NonNull Account execute(@NonFinal Account input) {
    input.createAccount();
    return accountRepositoryOutputPort.save(input);
  }
}
