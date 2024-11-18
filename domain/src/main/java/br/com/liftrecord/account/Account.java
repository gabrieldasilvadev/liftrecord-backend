package br.com.liftrecord.account;

import br.com.liftrecord.account.valueobjects.AccountId;
import br.com.liftrecord.account.valueobjects.Password;
import br.com.liftrecord.account.valueobjects.PersonName;
import br.com.liftrecord.core.DomainObject;
import br.com.liftrecord.student.valueobjects.StudentId;
import br.com.liftrecord.valueobjects.Contact;
import br.com.liftrecord.valueobjects.Address;
import br.com.liftrecord.visitor.Visitable;
import br.com.liftrecord.visitor.Visitor;
import jakarta.annotation.Nullable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

@Getter
public class Account extends DomainObject<AccountId> implements Visitable<Account> {
  private final PersonName personName;
  @Nullable
  private AccountStatus status;
  private final Contact contact;
  @Nullable
  private final Password password;
  @Nullable
  private final StudentId studentId;
  private final LocalDate birthDate;
  private final Address address;
  private final String gender;
  private final String biologicalSex;

  public Account(String firstName,
                 String lastName,
                 String email,
                 String cellphone,
                 LocalDate birthDate,
                 String gender,
                 String biologicalSex,
                 Address address) {
    this.personName = new PersonName(firstName, lastName);
    this.contact = new Contact(email, cellphone);
    this.birthDate = birthDate;
    this.address = address;
    this.gender = gender;
    this.biologicalSex = biologicalSex;
    this.password = null;
    this.status = null;
    this.studentId = null;
  }

  public Account(String id,
                 String firstName,
                 String lastName,
                 String email,
                 String cellphone,
                 String password,
                 @Nullable AccountStatus status,
                 LocalDate birthDate,
                 String gender,
                 String biologicalSex,
                 StudentId studentId,
                 Address address) {
    super(AccountId.fromString(id));
    this.personName = new PersonName(firstName, lastName);
    this.contact = new Contact(email, cellphone);
    this.password = new Password(password);
    this.status = status;
    this.birthDate = birthDate;
    this.gender = gender;
    this.biologicalSex = biologicalSex;
    this.address = address;
    this.studentId = studentId;
  }

  public void createAccount() {
    this.setId(new AccountId());
    this.status = AccountStatus.PENDING_ACTIVATION;
  }

  @Nullable
  public Optional<String> getPassword() {
    return Optional.ofNullable(ObjectUtils.defaultIfNull(password, new Password(null)).password());
  }

  public void inactivate() {
    if (Objects.isNull(this.status)) {
      throw new IllegalStateException("Account status is null");
    }

    if (this.status.isInactive()) {
      throw new IllegalStateException("Account is already inactive");
    }

    if (this.status.isPending() || Objects.requireNonNull(this.getStatus()).isActive()) {
      this.status = AccountStatus.INACTIVE;
    }
  }

  @Override
  public void accept(Visitor<Account, ?> visitor) {
    visitor.visit(this);
  }

  @Override
  public String toString() {
    return "Account{" +
        "name='" + personName.fullName() + '\'' +
        ", status=" + status +
        ", contact=" + contact +
        ", password=" + password +
        "} " + super.toString();
  }
}
