package br.com.liftrecord.student.register;

import br.com.liftrecord.command.Command;
import jakarta.validation.constraints.NotBlank;
import org.jetbrains.annotations.Nullable;

public record RegisterStudentCommand(
    @NotBlank
    String accountId,
    @NotBlank
    String academyId,
    @Nullable
    String goal,
    @Nullable
    String medicalConditions
) implements Command {
}
