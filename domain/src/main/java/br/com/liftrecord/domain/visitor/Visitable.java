package br.com.liftrecord.domain.visitor;

public abstract class Visitable {
  public abstract void accept(Visitor visitor);
}
