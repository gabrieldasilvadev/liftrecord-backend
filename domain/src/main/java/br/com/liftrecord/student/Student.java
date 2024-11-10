package br.com.liftrecord.student;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.core.DomainObject;
import br.com.liftrecord.student.valueobjects.BodyMetrics;
import br.com.liftrecord.account.valueobjects.Contact;
import br.com.liftrecord.student.valueobjects.StudentId;
import br.com.liftrecord.visitor.Visitable;
import br.com.liftrecord.visitor.Visitor;
import java.util.List;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Student extends DomainObject<StudentId> implements Visitable<Student> {
  private final String name;
  private final Contact contact;
  private Account account;
  private final List<BodyMetrics> bodyMetrics;


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

  public void inactivateAccount() {
    if (Objects.isNull(this.account)) {
      throw new IllegalStateException("Student does not have an account");
    }

    if (Objects.isNull(this.account.getStatus())) {
      throw new IllegalStateException("Account status is null");
    }

    if (this.account.getStatus().isInactive()) {
      throw new IllegalStateException("Student account is already inactive");
    }

    if (this.account.getStatus().isPending() || this.account.getStatus().isActive()) {
      this.account.inactivate();
    }
  }
}
