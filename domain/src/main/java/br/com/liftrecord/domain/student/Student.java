package br.com.liftrecord.domain.student;

import br.com.liftrecord.domain.student.valueobjects.Address;
import br.com.liftrecord.domain.student.valueobjects.BodyMetrics;
import br.com.liftrecord.domain.student.valueobjects.Cellphone;
import br.com.liftrecord.domain.student.valueobjects.Contact;
import br.com.liftrecord.domain.student.valueobjects.StudentId;
import br.com.liftrecord.domain.student.valueobjects.Email;
import br.com.liftrecord.domain.DomainObject;

public class Student extends DomainObject {
  private StudentId studentId;
  private String name;
  private Email email;
  private Cellphone cellphone;
  private Contact contact;
  private Address address;
  private BodyMetrics bodyMetrics;

  public Student(String name, String email, String cellphone) {
    this.name = name;
    this.email = new Email(email);
    this.cellphone = new Cellphone(cellphone);
  }

  public StudentId getStudentId() {
    return studentId;
  }

  public String getName() {
    return name;
  }

  public Email getEmail() {
    return email;
  }

  public Cellphone getCellphone() {
    return cellphone;
  }

  public Contact getContact() {
    return contact;
  }

  public Address getAddress() {
    return address;
  }

  public BodyMetrics getBodyMetrics() {
    return bodyMetrics;
  }
}
