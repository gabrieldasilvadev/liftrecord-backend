package br.com.liftrecord.visitor;

import br.com.liftrecord.domain.DomainObject;

public interface Visitor<T extends DomainObject> {
    void visit(T domainObject);
}
