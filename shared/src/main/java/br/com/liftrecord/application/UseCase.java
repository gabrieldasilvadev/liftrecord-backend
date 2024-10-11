package br.com.liftrecord.application;

import br.com.liftrecord.domain.DomainObject;

public interface UseCase<I, O extends DomainObject> {
    O execute(I input);
}
