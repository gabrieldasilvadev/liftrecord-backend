package br.com.liftrecord.domain.visitor;

import br.com.liftrecord.domain.DomainObject;

public interface Visitor<T extends DomainObject> {
  void visit(T domainObject);
}
