package br.com.liftrecord;

import br.com.liftrecord.exception.AccountAlreadyExistsException;
import br.com.liftrecord.exception.ObjectStateException;
import br.com.liftrecord.openapi.model.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HttpExceptionHandler {

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResponseDto> handleException(Exception ex, HttpServletRequest request) {
    return buildErrorResponse(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = {
      IllegalArgumentException.class,
      MethodArgumentNotValidException.class,
      ObjectStateException.class
  })
  public ResponseEntity<ErrorResponseDto> handleBadRequestException(Exception ex, HttpServletRequest request) {
    return buildErrorResponse(ex, request, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {
      AccountAlreadyExistsException.class
  })
  public ResponseEntity<ErrorResponseDto> handleAccountAlreadyExistsException(Exception ex, HttpServletRequest request) {
    return buildErrorResponse(ex, request, HttpStatus.CONFLICT);
  }

  private ResponseEntity<ErrorResponseDto> buildErrorResponse(Exception ex, HttpServletRequest request, HttpStatus status) {
    String message = ObjectUtils.firstNonNull(ex.getMessage(), "Unknown error: " + ex.getClass().getName());
    ErrorResponseDto errorResponse = ErrorResponseDto.builder()
        .message(message)
        .status(status.name())
        .uri(request.getRequestURI())
        .build();
    return ResponseEntity.status(status).body(errorResponse);
  }
}
