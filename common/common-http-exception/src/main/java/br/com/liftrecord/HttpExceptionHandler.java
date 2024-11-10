package br.com.liftrecord;

import br.com.liftrecord.exception.ObjectStateException;
import br.com.liftrecord.openapi.model.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HttpExceptionHandler {

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResponseDto> handleException(Exception ex, HttpServletRequest request) {
    ErrorResponseDto errorResponse = ErrorResponseDto.builder()
        .message(ex.getMessage())
        .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
        .uri(request.getRequestURI())
        .build();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
  }

  @ExceptionHandler(value = {
      IllegalArgumentException.class,
      MethodArgumentNotValidException.class,
      ObjectStateException.class})
  public ResponseEntity<ErrorResponseDto> handleBadRequestException(Exception ex, HttpServletRequest request) {
    ErrorResponseDto errorResponse = ErrorResponseDto.builder()
        .message(ex.getMessage())
        .status(HttpStatus.BAD_REQUEST.name())
        .uri(request.getRequestURI())
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }
}
