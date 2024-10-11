package br.com.liftrecord.command;

import br.com.liftrecord.domain.DomainObject;

public interface CommandHandler<I extends Command, O extends DomainObject> {

    default O doHandle(I command) {
        return canHandle(command) ? handle(command) : null;
    }

    O handle(I command);

    default boolean canHandle(I command) {
        return true;
    }
}
