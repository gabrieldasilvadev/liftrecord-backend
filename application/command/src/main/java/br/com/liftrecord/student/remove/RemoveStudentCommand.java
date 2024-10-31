package br.com.liftrecord.student.remove;

import br.com.liftrecord.command.Command;
import java.io.Serial;
import java.io.Serializable;

public record RemoveStudentCommand(
    String studentId
) implements Command, Serializable {

  @Serial
  private static final long serialVersionUID = -1838477336944876798L;
}
