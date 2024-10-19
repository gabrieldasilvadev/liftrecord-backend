package br.com.liftrecord.appmain;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.runtime.Micronaut;
import jakarta.persistence.Entity;

//@Introspected(packages = "br.com.liftrecord.dataaccess.tables", includedAnnotations = Entity.class)
public class Entrypoint {
  public static void main(String[] args) {
    Micronaut.run(Entrypoint.class, args);
  }
}