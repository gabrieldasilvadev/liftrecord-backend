package br.com.liftrecord.account.inactive;

import br.com.liftrecord.InactiveAccountUseCase;
import br.com.liftrecord.account.Account;
import br.com.liftrecord.account.valueobjects.AccountId;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.exception.ObjectStateException;
import br.com.liftrecord.account.inactive.validator.InactiveAccountValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InactiveAccountCommandHandler implements CommandHandler<InactiveAccountCommand, Account> {

  private final InactiveAccountUseCase inactiveAccountUseCase;
  private final InactiveAccountValidator inactiveAccountValidator;

  @Override
  public Account handle(@Valid InactiveAccountCommand command) {
    inactiveAccountValidator.validate(command).isInvalidThrow(ObjectStateException.class);
    return inactiveAccountUseCase.execute(AccountId.fromString(command.accountId()));
  }

  @Override
  public Class<InactiveAccountCommand> getCommandType() {
    return InactiveAccountCommand.class;
  }
}
