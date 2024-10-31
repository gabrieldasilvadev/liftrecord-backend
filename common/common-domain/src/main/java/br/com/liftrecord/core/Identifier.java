package br.com.liftrecord.core;

import java.util.Objects;
import lombok.Getter;

@Getter
public abstract class Identifier<T> extends ValueObject {
  private final T value;

  public Identifier(T value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Identifier<?> that = (Identifier<?>) o;
    return Objects.equals(getValue(), that.getValue());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getValue());
  }
}
