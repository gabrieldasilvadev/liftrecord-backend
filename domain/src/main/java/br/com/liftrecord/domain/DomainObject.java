package br.com.liftrecord.domain;

import br.com.liftrecord.domain.visitor.Visitable;
import br.com.liftrecord.domain.visitor.Visitor;

public abstract class DomainObject implements Visitable {

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
