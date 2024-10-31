package br.com.liftrecord.visitor;

public interface Visitable<T> {
  void accept(Visitor<T, ?>visitor);
}
