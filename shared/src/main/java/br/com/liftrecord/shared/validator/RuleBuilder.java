package br.com.liftrecord.shared.validator;

import java.util.function.Function;
import java.util.function.Predicate;

public class RuleBuilder<T, R> {
  private final AbstractValidator<T> abstractValidator;
  private final Function<T, R> extractor;
  private Predicate<R> condition;
  private String fieldName;
  private String message;
  private boolean critical = false;

  private ValidationRule<T> rule;

  public RuleBuilder(AbstractValidator<T> validator, Function<T, R> extractor) {
    this.abstractValidator = validator;
    this.extractor = extractor;
  }

  public RuleBuilder<T, R> must(Predicate<R> condition) {
    this.condition = condition;
    return this;
  }

  public RuleBuilder<T, R> when(Predicate<R> condition) {
    return this.must(condition);
  }

  public RuleBuilder<T, R> withMessage(String message) {
    this.message = message;
    return this;
  }

  public RuleBuilder<T, R> withFieldName(String fieldName) {
    this.fieldName = fieldName;
    return this;
  }

  public RuleBuilder<T, R> critical() {
    this.critical = true;
    return this;
  }

  public ValidationRule<T> getRule() {
    return new ValidationRule<>(
        t -> condition.test(extractor.apply(t)),
        fieldName,
        message,
        critical
    );
  }
}
