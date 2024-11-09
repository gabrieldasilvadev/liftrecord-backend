package br.com.liftrecord;

public interface UseCase<I, O> {
  O execute(I input);
}
