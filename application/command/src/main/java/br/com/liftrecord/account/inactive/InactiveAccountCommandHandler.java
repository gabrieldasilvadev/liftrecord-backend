package br.com.liftrecord.account.inactive;

import br.com.liftrecord.Log5WBuilder;
import br.com.liftrecord.account.Account;
import br.com.liftrecord.account.valueobjects.AccountId;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.exception.AccountNotFoundException;
import br.com.liftrecord.exception.ObjectStateException;
import br.com.liftrecord.account.inactive.validator.InactiveAccountValidator;
import br.com.liftrecord.ports.account.AccountRepositoryOutputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InactiveAccountCommandHandler implements CommandHandler<InactiveAccountCommand, Account> {

  private final InactiveAccountValidator inactiveAccountValidator;
  private final AccountRepositoryOutputPort accountRepositoryOutputPort;
  private final Logger logger = LoggerFactory.getLogger(InactiveAccountCommandHandler.class);

  @Override
  public Account handle(@Valid InactiveAccountCommand command) {
    Log5WBuilder
        .method()
        .logCode("IACH-HDL-01")
        .whatHappen("Inactive account")
        .addInfo("ACCOUNT_ID", command.accountId())
        .info(logger);

    inactiveAccountValidator.validate(command).isInvalidThrow(ObjectStateException.class);
    Account account = accountRepositoryOutputPort
        .findByAccountId(AccountId.fromString(command.accountId())).orElseThrow(() ->
            new AccountNotFoundException(String.format("Account with id %s not found", command.accountId())));
    account.inactivate();
    
    Log5WBuilder
        .method()
        .logCode("IACH-HDL-02")
        .whatHappen("Account inactivated successfully")
        .addInfo("ACCOUNT_DATA", account.toString())
        .info(logger);
    return accountRepositoryOutputPort.save(account);
  }

  @Override
  public Class<InactiveAccountCommand> getCommandType() {
    return InactiveAccountCommand.class;
  }
}
