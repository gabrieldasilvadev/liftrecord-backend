package br.com.liftrecord.account;

import br.com.liftrecord.LogException;
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
  public ResponseEntity<RegisterAccountResponseDto> postAccounts(RegisterAccountRequestDto registerAccountRequest) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(RegisterAccountControllerMapper.toResponse(mediator.execute(RegisterAccountControllerMapper.toCommand(registerAccountRequest))));
  }
}
