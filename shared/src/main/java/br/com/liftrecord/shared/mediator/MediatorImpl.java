package br.com.liftrecord.shared.mediator;

import br.com.liftrecord.domain.DomainObject;
import br.com.liftrecord.shared.Command;
import br.com.liftrecord.shared.CommandHandler;
import jakarta.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Singleton
public class MediatorImpl implements Mediator {

    private final Map<Class<?>, CommandHandler<?, ?>> handlerMap;

    public MediatorImpl(List<CommandHandler<?, ?>> handlers) {
        this.handlerMap = new HashMap<>();
        for (CommandHandler<?, ?> handler : handlers) {
            handlerMap.put(handler.getCommandType(), handler);
        }
    }

    @Override
    public <C extends Command, R extends DomainObject> R execute(C command) {
        CommandHandler<C, R> handler = (CommandHandler<C, R>) handlerMap.get(command.getClass());
        if (handler != null) {
            return (R) handler.handle(command);
        }
        throw new IllegalArgumentException("No handler found for command: " + command.getClass().getName());
    }
}
