package br.com.liftrecord.validator;

import java.util.function.Predicate;

public class ValidationRule<T> {
  private final Predicate<T> condition;
  private final String fieldName;
  private final String message;
  private final boolean critical;

  public ValidationRule(Predicate<T> condition, String fieldName, String message, boolean critical) {
    this.condition = condition;
    this.fieldName = fieldName;
    this.message = message;
    this.critical = critical;
  }

  public boolean isValid(T candidate) {
    return condition.test(candidate);
  }

  public String getErrorMessage() {
    return message;
  }

  public boolean isCritical() {
    return critical;
  }

  public String getFieldName() {
    return fieldName;
  }
}
