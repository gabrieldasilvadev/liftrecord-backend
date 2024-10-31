package br.com.liftrecord.student.register;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.command.Command;
import br.com.liftrecord.student.Student;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

public record RegisterStudentCommand(
    @NotBlank
    String name,
    @Email
    String email,
    @NotBlank
    @Size(min = 10, max = 21)
    String cellphone,
    @NotBlank
    @Size(min = 2, max = 2)
    String state,
    @NotBlank
    String city,
    @NotBlank
    String neighborhood,
    @NotBlank
    String street,
    @NotBlank
    @Size(min = 1, max = 5)
    String number,
    @Nullable
    String complement,
    @NotBlank
    @Size(min = 8, max = 9)
    String zipCode
) implements Command, Serializable {

  @Serial
  private static final long serialVersionUID = -8959707614555490587L;


  public Student toStudent() {
    return new Student(name,
        email,
        cellphone,
        state,
        city,
        neighborhood,
        street,
        number,
        complement,
        zipCode);
  }

  public Account toAccount() {
    return new Account(name, email, cellphone);
  }
}
