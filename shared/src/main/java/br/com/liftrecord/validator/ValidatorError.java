package br.com.liftrecord.validator;

import java.util.List;

public record ValidatorError(String field, String message) {
    public static String format(List<ValidatorError> errors) {
        StringBuilder sb = new StringBuilder();
        for (ValidatorError error : errors) {
            sb.append(String.format("Field: %s. Error: %s%n", error.field, error.message));
        }
        return sb.toString();
    }
}
