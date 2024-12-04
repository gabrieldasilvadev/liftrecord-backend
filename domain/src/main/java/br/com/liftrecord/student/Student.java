package br.com.liftrecord.student;

import br.com.liftrecord.academy.Academy;
import br.com.liftrecord.account.Account;
import br.com.liftrecord.core.DomainObject;
import br.com.liftrecord.exception.DomainException;
import br.com.liftrecord.student.valueobjects.BodyMetrics;
import br.com.liftrecord.student.valueobjects.StudentId;
import br.com.liftrecord.visitor.Visitable;
import br.com.liftrecord.visitor.Visitor;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Student extends DomainObject<StudentId> implements Visitable<Student> {
  private Account account;
  private Academy academy;
  private String goal;
  private String gymRegistrationStatus;
  private String medicalConditions;
  private LocalDate enrollmentDate;
  private LocalDate subscriptionEndDate;
  private Map<LocalDate, BodyMetrics> bodyMetrics;

  public Student() {
  }

  public static Student register(
      Account account,
      Academy academy,
      String goal,
      String medicalConditions
  ) {
    validateRegistration(account, academy);

    Student student = new Student();
    student.setId(new StudentId());
    student.account = account;
    student.academy = academy;
    student.goal = goal;
    student.medicalConditions = medicalConditions;

    student.gymRegistrationStatus = GymRegistrationStatus.PENDING_ACTIVATION.name();
    student.enrollmentDate = LocalDate.now();

    //TODO Domain Event

    return student;
  }

  private static void validateRegistration(Account account, Academy academy) {
    if (account == null) {
      throw new DomainException("Account is mandatory for student registration");
    }
//    if (academy == null) {
//      throw new DomainException("Academy is mandatory for student registration");
//    }
    if (account.hasActiveStudent()) {
      throw new DomainException("Account already has an active student");
    }
  }

  private enum GymRegistrationStatus {
    PENDING_ACTIVATION,
    ACTIVE,
    INACTIVE
  }

  public void assignBodyMetrics(BodyMetrics bodyMetrics) {
    Objects.requireNonNull(bodyMetrics, "Body metrics cannot be null");
    bodyMetrics.setCurrent();
    this.bodyMetrics.put(LocalDate.now(), bodyMetrics);
  }

  @Override
  public String toString() {
    return "Student{" +
        ", account=" + account +
        ", bodyMetrics=" + bodyMetrics +
        "} " + super.toString();
  }

  @Override
  public void accept(Visitor<?, Student> visitor) {
    visitor.visit(this);
  }

  public Map<LocalDate, BodyMetrics> getBodyMetrics() {
    return Collections.unmodifiableMap(this.bodyMetrics);
  }
}
