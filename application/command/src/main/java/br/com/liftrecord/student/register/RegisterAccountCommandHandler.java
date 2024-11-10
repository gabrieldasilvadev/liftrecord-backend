package br.com.liftrecord.student.register;

import br.com.liftrecord.CreateAccountUseCase;
import br.com.liftrecord.Log5WBuilder;
import br.com.liftrecord.account.Account;
import br.com.liftrecord.exception.AccountAlreadyExistsException;
import br.com.liftrecord.exception.ObjectStateException;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.student.register.validator.RegisterAccountValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterAccountCommandHandler implements CommandHandler<RegisterAccountCommand, Account> {

  private static final Logger logger = LoggerFactory.getLogger(RegisterAccountCommandHandler.class);
  private final CreateAccountUseCase createAccountUseCase;
  private final RegisterAccountValidator registerAccountValidator;

  @Override
  public Account handle(@Valid final RegisterAccountCommand command) {
    Log5WBuilder
        .method()
        .logCode("RACH-HDL-01")
        .whatHappen("Starting account registration flow")
        .addInfo("REGISTER_ACCOUNT_COMMAND_DATA", command.toString())
        .info(logger);

    registerAccountValidator.validate(command).isInvalidThrow(ObjectStateException.class);
    Account newAccount;
    try {
      final Account accountFromCommand = command.toAccount();
      newAccount = createAccountUseCase.execute(accountFromCommand);
    } catch (AccountAlreadyExistsException accountAlreadyExistsException) {
      Log5WBuilder
          .method()
          .logCode("RACH-HDL-02")
          .whatHappen("Account already exists")
          .addInfo("ACCOUNT_DATA", command.toAccount().toString())
          .info(logger);
      return command.toAccount();
    }

    Log5WBuilder
        .method()
        .logCode("RACH-HDL-03")
        .whatHappen("Account registered successfully")
        .addInfo("ACCOUNT_DATA", newAccount.toString())
        .info(logger);
    return newAccount;
  }

  @Override
  public Class<RegisterAccountCommand> getCommandType() {
    return RegisterAccountCommand.class;
  }
}