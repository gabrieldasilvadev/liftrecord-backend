
package br.com.liftrecord.account;

import br.com.liftrecord.openapi.model.RegisterAccountRequestDto;
import br.com.liftrecord.openapi.model.RegisterAccountResponseDto;
import br.com.liftrecord.student.register.RegisterAccountCommand;

public class RegisterAccountControllerMapper {

  public static RegisterAccountCommand toCommand(RegisterAccountRequestDto registerAccountRequestDto) {
    return new RegisterAccountCommand(
        registerAccountRequestDto.getName(),
        registerAccountRequestDto.getEmail(),
        registerAccountRequestDto.getCellphone(),
        registerAccountRequestDto.getAddress().getState(),
        registerAccountRequestDto.getAddress().getCity(),
        registerAccountRequestDto.getAddress().getNeighborhood(),
        registerAccountRequestDto.getAddress().getStreet(),
        registerAccountRequestDto.getAddress().getNumber(),
        registerAccountRequestDto.getAddress().getComplement(),
        registerAccountRequestDto.getAddress().getZipCode()
    );
  }

  public static RegisterAccountResponseDto toResponse(Account account) {
    return new RegisterAccountResponseDto()
        .name(account.getName())
        .email(account.getContact().getEmail().getValue())
        .cellphone(account.getContact().getCellphone().getFullNumber())
        .status(account.getStatus().name());
  }
}
