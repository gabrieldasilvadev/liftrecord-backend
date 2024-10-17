package br.com.liftrecord.shared.mediator;

import br.com.liftrecord.domain.core.DomainObject;
import br.com.liftrecord.shared.Command;

public interface Mediator {
    <C extends Command, R extends DomainObject> R execute(C command);
}