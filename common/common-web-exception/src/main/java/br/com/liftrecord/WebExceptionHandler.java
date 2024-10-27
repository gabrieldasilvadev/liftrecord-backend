package br.com.liftrecord;

import br.com.liftrecord.openapi.model.ErrorResponseDto;
import br.com.liftrecord.student.register.validator.RegisterStudentValidationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionHandler {

  @ExceptionHandler(value = {
      IllegalArgumentException.class,
      MethodArgumentNotValidException.class})
  public ResponseEntity<ErrorResponseDto> handleBadRequestException(Exception ex, HttpServletRequest request) {
    ErrorResponseDto errorResponse = ErrorResponseDto.builder()
        .message(ex.getMessage())
        .status(HttpStatus.BAD_REQUEST.name())
        .uri(request.getRequestURI())
        .additionalInfo(null)
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }


  @ExceptionHandler(RegisterStudentValidationException.class)
  public ResponseEntity<ErrorResponseDto> handleBadRequestException(RegisterStudentValidationException ex, HttpServletRequest request) {
    ErrorResponseDto errorResponse = ErrorResponseDto.builder()
        .additionalInfo(ex.getValidationResult().getErrors())
        .status(HttpStatus.BAD_REQUEST.name())
        .uri(request.getRequestURI())
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }
}
