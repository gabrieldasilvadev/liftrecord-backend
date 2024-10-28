package br.com.liftrecord.student.register;

import br.com.liftrecord.command.Command;
import br.com.liftrecord.student.Student;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegisterStudentCommand implements Command {
  private String name;
  private String email;
  private String cellphone;
  private String state;
  private String city;
  private String neighborhood;
  private String street;
  private String number;
  private String complement;
  private String zipCode;

  @Override
  public String toString() {
    return "RegisterStudentCommand{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", cellphone='" + cellphone + '\'' +
        ", state='" + state + '\'' +
        ", city='" + city + '\'' +
        ", neighborhood='" + neighborhood + '\'' +
        ", street='" + street + '\'' +
        ", number='" + number + '\'' +
        ", complement='" + complement + '\'' +
        ", zipCode='" + zipCode + '\'' +
        "} " + super.toString();
  }

  public Student toStudent() {
    return new Student(name,
        email,
        cellphone,
        state,
        city,
        neighborhood,
        street,
        number,
        complement,
        zipCode);
  }
}
