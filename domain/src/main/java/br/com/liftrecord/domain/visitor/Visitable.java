package br.com.liftrecord.domain.visitor;

public interface Visitable {
  void accept(Visitor visitor);
}
