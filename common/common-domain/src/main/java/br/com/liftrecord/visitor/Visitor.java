package br.com.liftrecord.visitor;

public interface Visitor<R, T> {
  R visit(T candidate);
}