package br.com.liftrecord.api.exception.handlers;

import br.com.liftrecord.api.exception.ErrorResponse;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import java.util.Objects;

@Produces
@Singleton
@Requires(classes = {RuntimeException.class, ExceptionHandler.class})
public class GlobalExceptionHandler implements ExceptionHandler<RuntimeException, HttpResponse> {

  @Override
  public HttpResponse handle(HttpRequest request, RuntimeException exception) {
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    String message = "An unexpected error occurred";
    return HttpResponse.status(status)
        .body(ErrorResponse.of(status.getCode(), Objects.requireNonNullElse(exception.getMessage(), message)));
  }
}
