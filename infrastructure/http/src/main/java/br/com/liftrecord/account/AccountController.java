package br.com.liftrecord.account;

import br.com.liftrecord.LogException;
import br.com.liftrecord.account.inactive.InactiveAccountCommand;
import br.com.liftrecord.mediator.Mediator;
import br.com.liftrecord.openapi.api.AccountApi;
import br.com.liftrecord.openapi.model.RegisterAccountRequestDto;
import br.com.liftrecord.openapi.model.RegisterAccountResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AccountApi {

  private final Mediator mediator;

  public AccountController(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  @LogException
  public ResponseEntity<RegisterAccountResponseDto> postApiV1Accounts(RegisterAccountRequestDto registerAccountRequestDto) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(RegisterAccountControllerMapper.toResponse(mediator
            .execute(RegisterAccountControllerMapper.toCommand(registerAccountRequestDto))));
  }

  @Override
  @LogException
  public ResponseEntity<Void> deleteApiV1AccountsAccountId(String accountId) {
    mediator.execute(new InactiveAccountCommand(accountId));
    return ResponseEntity.noContent().build();
  }
}
