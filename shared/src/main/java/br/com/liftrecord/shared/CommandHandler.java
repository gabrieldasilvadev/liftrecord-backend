package br.com.liftrecord.shared;

import br.com.liftrecord.domain.core.DomainObject;

@SuppressWarnings("unchecked")
public interface CommandHandler<I extends Command, O extends DomainObject> {

  default O doHandle(I inputData) {
    return canHandle(inputData) ? (O) handle(inputData) : null;
  }

  DomainObject handle(I command);

  default boolean canHandle(I command) {
    return true;
  }

  Class<I> getCommandType();
}
