package br.com.liftrecord;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.exception.AccountAlreadyExistsException;
import br.com.liftrecord.ports.account.AccountRepositoryOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateAccountUseCase implements UseCase<Account, Account>{

  private final AccountRepositoryOutputPort accountRepositoryOutputPort;

  @Override
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public @NonNull Account execute(@NonFinal Account input) {

    boolean accountAlreadyExists = accountRepositoryOutputPort.existsByEmail(input.getContact().getEmail());
    if (accountAlreadyExists) {
      throw new AccountAlreadyExistsException("This account has already started the registration process: ", input);
    }

    input.createAccount();
    return accountRepositoryOutputPort.save(input);
  }
}
