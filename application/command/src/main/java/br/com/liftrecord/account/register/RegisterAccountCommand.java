package br.com.liftrecord.account.register;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.command.Command;
import br.com.liftrecord.valueobjects.Address;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public record RegisterAccountCommand(
    @NotBlank
    String firstName,
    @NotBlank
    String lastName,
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
    String zipCode,
    @NotBlank
    @Size(min = 10, max = 11)
    @Past
    LocalDate birthDate,
    @NotBlank
    String gender,
    @NotBlank
    String biologicalSex
) implements Command, Serializable {

  @Serial
  private static final long serialVersionUID = -8959707614555490587L;

  public Account toAccount() {
    return new Account(firstName,
        lastName,
        email,
        cellphone,
        birthDate,
        gender,
        biologicalSex,
        new Address(state, city, neighborhood, street, number, complement, zipCode));
  }
}
