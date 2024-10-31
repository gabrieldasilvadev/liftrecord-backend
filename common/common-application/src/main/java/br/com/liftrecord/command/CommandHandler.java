package br.com.liftrecord.command;

@SuppressWarnings("unchecked")
public interface CommandHandler<I extends Command, O> {

  default O doHandle(I inputData) {
    return canHandle(inputData) ? (O) handle(inputData) : null;
  }

  O handle(I command);

  default boolean canHandle(I command) {
    return true;
  }

  Class<I> getCommandType();
}
