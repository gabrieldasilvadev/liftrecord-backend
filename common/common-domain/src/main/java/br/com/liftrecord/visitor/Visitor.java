package br.com.liftrecord.visitor;

public interface Visitor<T, R> {
  R visit(T candidate);
}
