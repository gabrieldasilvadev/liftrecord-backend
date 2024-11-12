package br.com.liftrecord.account.inactive.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.liftrecord.account.inactive.InactiveAccountCommand;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class InactiveAccountValidator extends AbstractValidator<InactiveAccountCommand> {

  @Override
  public void rules() {
    ruleFor(InactiveAccountCommand::accountId)
        .must(email -> !email.isBlank())
        .when(String::isBlank)
        .withCode("ACCOUNT_ID_IS_BLANK")
        .withMessage("accountId cannot be blank")
        .withFieldName("accountId")
        .critical();

    ruleFor(InactiveAccountCommand::accountId)
        .must(email -> email.length() == 26)
        .when(Predicate.not(email -> email.length() == 26))
        .withCode("ACCOUNT_ID_INVALID_LENGTH")
        .withMessage("accountId length must be 26")
        .withFieldName("accountId")
        .critical();
  }
}
