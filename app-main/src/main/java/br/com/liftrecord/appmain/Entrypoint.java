package br.com.liftrecord.appmain;

import io.micronaut.runtime.Micronaut;

public class Entrypoint {

  public static void main(String[] args) {
    Micronaut.run(Entrypoint.class, args);
  }
}