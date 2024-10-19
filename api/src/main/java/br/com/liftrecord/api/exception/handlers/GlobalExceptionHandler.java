//package br.com.liftrecord.api.exception.handlers;
//
//import br.com.liftrecord.api.exception.ErrorResponse;
//import java.util.Objects;
//
//public class GlobalExceptionHandler implements ExceptionHandler<RuntimeException, HttpResponse> {
//
//  @Override
//  public HttpResponse handle(HttpRequest request, RuntimeException exception) {
//    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
//    String message = "An unexpected error occurred";
//    return HttpResponse.status(status)
//        .body(ErrorResponse.of(status.getCode(), Objects.requireNonNullElse(exception.getMessage(), message)));
//  }
//}
