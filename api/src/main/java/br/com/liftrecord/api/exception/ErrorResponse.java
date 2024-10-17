package br.com.liftrecord.api.exception;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ErrorResponse(int status, String message) {
    public static ErrorResponse of(int status, String message) {
        return new ErrorResponse(status, message);
    }
}