package br.com.liftrecord.domain;

import br.com.liftrecord.visitor.Visitable;
import br.com.liftrecord.visitor.Visitor;

public abstract class DomainObject extends Visitable {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
