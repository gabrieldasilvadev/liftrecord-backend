
package br.com.liftrecord.account;

import br.com.liftrecord.openapi.model.RegisterAccountRequestDto;
import br.com.liftrecord.openapi.model.RegisterAccountResponseDto;
import br.com.liftrecord.account.register.RegisterAccountCommand;

public class RegisterAccountControllerMapper {

  public static RegisterAccountCommand toCommand(RegisterAccountRequestDto registerAccountRequestDto) {
    return new RegisterAccountCommand(
        registerAccountRequestDto.getFirstName(),
        registerAccountRequestDto.getLastName(),
        registerAccountRequestDto.getEmail(),
        registerAccountRequestDto.getCellphone(),
        registerAccountRequestDto.getAddress().getState(),
        registerAccountRequestDto.getAddress().getCity(),
        registerAccountRequestDto.getAddress().getNeighborhood(),
        registerAccountRequestDto.getAddress().getStreet(),
        registerAccountRequestDto.getAddress().getNumber(),
        registerAccountRequestDto.getAddress().getComplement(),
        registerAccountRequestDto.getAddress().getZipCode(),
        registerAccountRequestDto.getBirthDate(),
        registerAccountRequestDto.getGender(),
        registerAccountRequestDto.getBiologicalSex()
    );
  }

  public static RegisterAccountResponseDto toResponse(Account account) {
    assert account.getContact().getEmail() != null;
    assert account.getContact().getCellphone() != null;
    assert account.getStatus() != null;
    return new RegisterAccountResponseDto()
        .accountId(account.getId().getValue())
        .name(account.getPersonName().fullName())
        .email(account.getContact().getEmail().getValue())
        .cellphone(account.getContact().getCellphone().getFullNumber())
        .birthDate(account.getBirthDate())
        .status(account.getStatus().name());
  }
}

