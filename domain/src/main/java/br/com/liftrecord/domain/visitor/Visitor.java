package br.com.liftrecord.domain.visitor;

public interface Visitor<T, R> {
  R visit(T candidate);
}
