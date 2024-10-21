package br.com.liftrecord.mediator;

import br.com.liftrecord.command.Command;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.core.DomainObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@SuppressWarnings("unchecked")
@Component
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
