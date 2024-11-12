package br.com.liftrecord.account.inactive;

import br.com.liftrecord.command.Command;
import java.io.Serial;
import java.io.Serializable;

public record InactiveAccountCommand(
    String accountId
) implements Command, Serializable {

  @Serial
  private static final long serialVersionUID = -1838477336944876798L;
}
