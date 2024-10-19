package br.com.liftrecord.appmain.beans;

import br.com.liftrecord.student.ports.SaveStudentOutputPort;
import database.adapters.SaveStudentAdapter;
import database.repositories.StudentRepository;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;
import jakarta.inject.Singleton;

@Factory
@Requires(beans = StudentRepository.class)
public class SaveStudentOutputPortBean {

  @Bean
  @Singleton
  public SaveStudentOutputPort saveStudentOutputPort(StudentRepository repository) {
    return new SaveStudentAdapter(repository);
  }
}
