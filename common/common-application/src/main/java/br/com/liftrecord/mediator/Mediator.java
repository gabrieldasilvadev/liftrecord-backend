package br.com.liftrecord.mediator;

import br.com.liftrecord.command.Command;
import br.com.liftrecord.core.DomainObject;

public interface Mediator {
    <C extends Command, R extends DomainObject> R execute(C command);
}