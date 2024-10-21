package br.com.liftrecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EnableJpaRepositories(basePackages = "br.com.liftrecord.repositories")
@EntityScan(basePackages = "br.com.liftrecord.tables")
@SpringBootApplication(scanBasePackages = "br.com.liftrecord")
public class Entrypoint {
  public static void main(String[] args) {
    SpringApplication.run(Entrypoint.class, args);
  }
}