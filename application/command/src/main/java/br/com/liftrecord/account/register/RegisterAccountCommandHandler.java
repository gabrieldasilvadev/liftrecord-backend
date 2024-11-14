package br.com.liftrecord.account.register;

import br.com.liftrecord.Log5WBuilder;
import br.com.liftrecord.account.Account;
import br.com.liftrecord.exception.AccountAlreadyExistsException;
import br.com.liftrecord.exception.ObjectStateException;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.account.register.validator.RegisterAccountValidator;
import br.com.liftrecord.ports.account.AccountRepositoryOutputPort;
import br.com.liftrecord.valueobjects.Email;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterAccountCommandHandler implements CommandHandler<RegisterAccountCommand, Account> {

  private static final Logger logger = LoggerFactory.getLogger(RegisterAccountCommandHandler.class);
  private final AccountRepositoryOutputPort accountRepositoryOutputPort;
  private final RegisterAccountValidator registerAccountValidator;

  @Override
  @Transactional(isolation = Isolation.SERIALIZABLE)
  public Account handle(@Valid final RegisterAccountCommand command) {
    Log5WBuilder
        .method()
        .logCode("RACH-HDL-01")
        .whatHappen("Starting account registration flow")
        .addInfo("REGISTER_ACCOUNT_COMMAND_DATA", command.toString())
        .info(logger);

    registerAccountValidator.validate(command).isInvalidThrow(ObjectStateException.class);
    Account account;
    try {
      boolean accountAlreadyExists = accountRepositoryOutputPort.existsByEmail(Email.fromString(command.email()));
      if (accountAlreadyExists) throw new AccountAlreadyExistsException("This account has already started the registration process");

      account = command.toAccount();
      account.createAccount();
    } catch (AccountAlreadyExistsException accountAlreadyExistsException) {
      Log5WBuilder
          .method()
          .logCode("RACH-HDL-02")
          .whatHappen("Account in process of registration")
          .addInfo("REGISTER_ACCOUNT_COMMAND_DATA", command.toString())
          .info(logger);
      throw accountAlreadyExistsException;
    }
    Log5WBuilder
        .method()
        .logCode("RACH-HDL-03")
        .whatHappen("Account registered successfully")
        .addInfo("ACCOUNT_DATA", account.toString())
        .info(logger);
    return account;
  }

  @Override
  public Class<RegisterAccountCommand> getCommandType() {
    return RegisterAccountCommand.class;
  }
}