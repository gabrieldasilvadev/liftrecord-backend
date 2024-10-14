package br.com.liftrecord.bean;

import br.com.liftrecord.application.student.ports.SaveStudentOutputPort;
import br.com.liftrecord.dataaccess.adapters.SaveStudentAdapter;
import br.com.liftrecord.dataaccess.repositories.StudentRepository;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;
import jakarta.inject.Singleton;

@Factory
@Requires(beans = StudentRepository.class)
public class SaveStudentOutputPortBeanConfig {

  @Bean
  @Singleton
  public SaveStudentOutputPort saveStudentOutputPort(StudentRepository repository) {
    return new SaveStudentAdapter(repository);
  }
}
