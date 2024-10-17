package br.com.liftrecord.domain.visitor;

public interface Visitable<T> {
  void accept(Visitor<T, ?> visitor);
}
