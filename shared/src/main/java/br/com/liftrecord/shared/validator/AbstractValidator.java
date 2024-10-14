package br.com.liftrecord.shared.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractValidator<T> {
  private final List<ValidationRule<T>> rules = new ArrayList<>();

  protected abstract void rules();

  protected <R> RuleBuilder<T, R> ruleFor(Function<T, R> extractor) {
    RuleBuilder<T, R> builder = new RuleBuilder<>(this, extractor);
    rules.add(builder.getRule());
    return builder;
  }

  public List<String> validate(T object) {
    List<String> errors = new ArrayList<>();
    rules.forEach(rule -> {
      if (!rule.isValid(object) && !rule.isCritical()) {
        errors.add(rule.getErrorMessage());
      }
    });
    return errors;
  }

  public InvalidStateException validateWithException(T object) {
    List<ValidatorError> errors = validateWithErrors(object);
    if (!errors.isEmpty()) {
      throw new InvalidStateException(errors);
    }
    return null;
  }

  public RuntimeException validateWithException(T object, RuntimeException exception) {
    List<ValidatorError> errors = validateWithErrors(object);
    if (!errors.isEmpty()) {
      throw exception;
    }
    return null;
  }

  public List<ValidatorError> validateWithErrors(T object) {
    List<ValidatorError> errors = new ArrayList<>();
    rules.forEach(rule -> {
      if (!rule.isValid(object) && rule.isCritical()) {
        errors.add(new ValidatorError(rule.getFieldName(), rule.getErrorMessage()));
      }
    });
    return errors;
  }

  public List<ValidatorError> getErrors() {
    List<ValidatorError> errors = new ArrayList<>();
    rules.forEach(rule -> {
      if (!rule.isValid(null) && rule.isCritical()) {
        errors.add(new ValidatorError(rule.getFieldName(), rule.getErrorMessage()));
      }
    });
    return errors;
  }
}
