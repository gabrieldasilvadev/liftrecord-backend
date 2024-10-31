package br.com.liftrecord.student;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.core.DomainObject;
import br.com.liftrecord.student.valueobjects.Address;
import br.com.liftrecord.student.valueobjects.BodyMetrics;
import br.com.liftrecord.account.valueobjects.Contact;
import br.com.liftrecord.student.valueobjects.StudentId;
import br.com.liftrecord.visitor.Visitable;
import br.com.liftrecord.visitor.Visitor;
import java.util.Objects;
import lombok.Getter;

@Getter
public class Student extends DomainObject<StudentId> implements Visitable<Student> {
  private String name;
  private Contact contact;
  private Address address;
  private Account account;
  private BodyMetrics bodyMetrics;


  public Student(String name,
                 String email,
                 String cellphone,
                 String state,
                 String city,
                 String neighborhood,
                 String street,
                 String number,
                 String complement,
                 String zipCode) {
    this.name = Objects.requireNonNull(name, "Name cannot be null");
    this.contact = new Contact(email,cellphone);
    this.address = new Address(state, city, neighborhood, street, number, complement, zipCode);
    this.bodyMetrics = null;
    this.account = null;
  }

  public Student() {
  }

  @Override
  public void accept(Visitor<Student, ?> visitor) {
    visitor.visit(this);
  }

  public void registerStudent() {
    super.setId(new StudentId());
  }

  public void assignAccount(Account account) {
    Objects.requireNonNull(account, "Account cannot be null");

    if (!Objects.isNull(this.account)) {
      throw new IllegalStateException("Student already has an account");
    }

    this.account = account;
  }
}
