package br.com.liftrecord;

import br.com.liftrecord.core.DomainObject;

public interface UseCase<I, O extends DomainObject> {
  O execute(I input);
}