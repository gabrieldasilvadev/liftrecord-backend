package br.com.liftrecord.account.register.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.PredicateBuilder;
import br.com.liftrecord.account.register.RegisterAccountCommand;
import java.time.LocalDate;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class RegisterAccountValidator extends AbstractValidator<RegisterAccountCommand> {

  private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
  Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

  @Override
  public void rules() {
    ruleFor(RegisterAccountCommand::name)
        .must(name -> !name.isEmpty())
        .when(String::isBlank)
        .withCode("NAME_IS_BLANK")
        .withMessage("Name cannot be blank")
        .withFieldName("name")
        .critical();

    ruleFor(RegisterAccountCommand::email)
        .must(PredicateBuilder.from(email -> email != null && emailPattern.matcher(email).matches()))
        .withCode("EMAIL_PATTERN_INVALID")
        .withMessage("Email pattern is invalid")
        .withFieldName("email")
        .critical();

    ruleFor(RegisterAccountCommand::number)
        .must(PredicateBuilder.from(size -> size.length() <= 5))
        .withCode("NUMBER_INVALID_LENGTH")
        .withMessage("Number length must be between 1 and 5")
        .withFieldName("number")
        .critical();

    ruleFor(RegisterAccountCommand::zipCode)
        .must(PredicateBuilder.from(size -> size.length() < 10))
        .withCode("ZIPCODE_INVALID_LENGTH")
        .withMessage("ZipCode length must be between 8 and 9")
        .withFieldName("zipCode")
        .critical();

    ruleFor(RegisterAccountCommand::cellphone)
        .must(PredicateBuilder.from(cellphone -> cellphone.length() >= 10 && cellphone.length() <= 21))
        .withCode("CELLPHONE_INVALID_LENGTH")
        .withMessage("Cellphone length must be between 10 and 21")
        .withFieldName("cellphone")
        .critical();

    ruleFor(RegisterAccountCommand::street)
        .must(PredicateBuilder.from(street -> street.length() > 1 && street.length() <= 80))
        .withCode("STREET_INVALID_LENGTH")
        .withMessage("Street length must be between 1 and 80")
        .withFieldName("street")
        .critical();

    ruleFor(RegisterAccountCommand::neighborhood)
        .must(PredicateBuilder.from(neighborhood -> neighborhood.length() > 1 && neighborhood.length() <= 80))
        .withCode("NEIGHBORHOOD_INVALID_LENGTH")
        .withMessage("Neighborhood length must be between 1 and 80")
        .withFieldName("neighborhood")
        .critical();

    ruleFor(RegisterAccountCommand::city)
        .must(PredicateBuilder.from(city -> city.length() > 1 && city.length() <= 20))
        .withCode("CITY_INVALID_LENGTH")
        .withMessage("City length must be between 1 and 20")
        .withFieldName("city")
        .critical();

    ruleFor(RegisterAccountCommand::state)
        .must(PredicateBuilder.from(state -> state.length() == 2))
        .withCode("STATE_INVALID_LENGTH")
        .withMessage("State length must be 2")
        .withFieldName("state")
        .critical();
    ruleFor(RegisterAccountCommand::birthDate)
        .must(PredicateBuilder.from(date -> date.isBefore(LocalDate.now())))
        .withCode("BIRTH_DATE_INVALID")
        .withMessage("Birth date must be before today")
        .withFieldName("birthDate")
        .critical();
  }
}
