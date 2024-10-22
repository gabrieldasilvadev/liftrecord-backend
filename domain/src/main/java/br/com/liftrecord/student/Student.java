package br.com.liftrecord.student;

import br.com.liftrecord.core.DomainObject;
import br.com.liftrecord.student.valueobjects.Address;
import br.com.liftrecord.student.valueobjects.BodyMetrics;
import br.com.liftrecord.student.valueobjects.Cellphone;
import br.com.liftrecord.student.valueobjects.Contact;
import br.com.liftrecord.student.valueobjects.Email;
import br.com.liftrecord.student.valueobjects.StudentId;
import br.com.liftrecord.visitor.Visitable;
import br.com.liftrecord.visitor.Visitor;
import de.huxhorn.sulky.ulid.ULID;
import java.util.Objects;
import lombok.Getter;

@Getter
public class Student extends DomainObject<StudentId> implements Visitable<Student> {
  private final String name;
  private final Contact contact;
  private final Address address;
  private final BodyMetrics bodyMetrics;

  private AccountStatus status;

  public Student(String name, String email, String cellphone, String state, String city, String neighborhood, String street, String number, String complement, String zipCode) {
    this.name = Objects.requireNonNull(name, "Name cannot be null");
    this.contact = new Contact(new Email(email), new Cellphone(cellphone));
    this.address = new Address(state, city, neighborhood, street, number, complement, zipCode);
    this.bodyMetrics = null;
    this.status = null;
  }

  @Override
  public void accept(Visitor<Student, ?> visitor) {
    visitor.visit(this);
  }

  public void initializeStudent() {
    super.setId(new StudentId(new ULID().nextULID()));
    this.status = AccountStatus.PENDING_ACTIVATION;
  }
}