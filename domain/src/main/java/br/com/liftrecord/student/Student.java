package br.com.liftrecord.student;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.core.DomainObject;
import br.com.liftrecord.student.valueobjects.BodyMetrics;
import br.com.liftrecord.valueobjects.Contact;
import br.com.liftrecord.student.valueobjects.StudentId;
import br.com.liftrecord.visitor.Visitable;
import br.com.liftrecord.visitor.Visitor;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Student extends DomainObject<StudentId> implements Visitable<Student> {
  private final String name;
  private final Contact contact;
  private Account account;
  private Map<LocalDate, BodyMetrics> bodyMetrics;


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
      // TODO: throw an domain exception
      throw new IllegalStateException("Student already has an account");
    }
    this.account = account;
  }

  public void assignBodyMetrics(BodyMetrics bodyMetrics) {
    Objects.requireNonNull(bodyMetrics, "Body metrics cannot be null");
    bodyMetrics.setCurrent();
    this.bodyMetrics.put(LocalDate.now(), bodyMetrics);
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", contact=" + contact +
        ", account=" + account +
        ", bodyMetrics=" + bodyMetrics +
        "} " + super.toString();
  }
}
