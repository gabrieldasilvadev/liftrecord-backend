package br.com.liftrecord.student.inactive;

import br.com.liftrecord.command.Command;
import java.io.Serial;
import java.io.Serializable;

public record InactiveStudentCommand(
    String studentId
) implements Command, Serializable {

  @Serial
  private static final long serialVersionUID = -1838477336944876798L;
}
