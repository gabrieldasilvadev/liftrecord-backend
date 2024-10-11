package br.com.liftrecord.validator;

import java.io.Serial;
import java.util.List;

public class InvalidStateException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5080777268056689990L;

    public InvalidStateException(List<ValidatorError> errors) {
        super(ValidatorError.format(errors));
    }
}
