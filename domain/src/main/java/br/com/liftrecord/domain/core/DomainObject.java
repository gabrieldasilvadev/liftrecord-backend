package br.com.liftrecord.domain.core;

import java.io.Serializable;
import java.util.Objects;

public abstract class DomainObject<I> implements Serializable {
  private I id;

  public I getId() {
    return id;
  }

  public void setId(I id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DomainObject<?> that = (DomainObject<?>) o;
    return Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }
}
