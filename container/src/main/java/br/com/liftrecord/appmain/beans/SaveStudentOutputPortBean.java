package br.com.liftrecord.appmain.beans;

import br.com.liftrecord.student.ports.SaveStudentOutputPort;
import database.adapters.SaveStudentAdapter;
import database.repositories.StudentRepository;

public class SaveStudentOutputPortBean {

  public SaveStudentOutputPort saveStudentOutputPort(StudentRepository repository) {
    return new SaveStudentAdapter(repository);
  }
}
