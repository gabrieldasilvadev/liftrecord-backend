package br.com.liftrecord.visitor;

public abstract class Visitable {
    public abstract void accept(Visitor visitor);
}
