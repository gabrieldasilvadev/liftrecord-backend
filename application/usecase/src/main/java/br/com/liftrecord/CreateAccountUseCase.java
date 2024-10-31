package br.com.liftrecord;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.ports.account.SaveAccountOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAccountUseCase implements UseCase<Account, Account>{

  private final SaveAccountOutputPort saveAccountOutputPort;

  @Override
  public Account execute(@NonFinal Account input) {
    input.createAccount();
    return saveAccountOutputPort.save(input);
  }
}
