package br.com.liftrecord.student;

import br.com.liftrecord.academy.AcademyId;
import br.com.liftrecord.account.valueobjects.AccountId;
import br.com.liftrecord.core.DomainObject;
import br.com.liftrecord.student.valueobjects.BodyMetrics;
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
  private AccountId accountId;
  private AcademyId academyId;
  private String goal;
  private String gymRegistrationStatus;
  private String medicalConditions;
  private LocalDate enrollmentDate;
  private LocalDate subscriptionEndDate;
  private Map<LocalDate, BodyMetrics> bodyMetrics;


  @Override
  public void accept(Visitor<Student, ?> visitor) {
    visitor.visit(this);
  }

  public void initializeRegister() {
    super.setId(new StudentId());
    this.gymRegistrationStatus = "PENDING_ACTIVATION";
    this.enrollmentDate = LocalDate.now();
  }

  public void assignBodyMetrics(BodyMetrics bodyMetrics) {
    Objects.requireNonNull(bodyMetrics, "Body metrics cannot be null");
    bodyMetrics.setCurrent();
    this.bodyMetrics.put(LocalDate.now(), bodyMetrics);
  }

  @Override
  public String toString() {
    return "Student{" +
        ", accountId=" + accountId +
        ", bodyMetrics=" + bodyMetrics +
        "} " + super.toString();
  }
}
