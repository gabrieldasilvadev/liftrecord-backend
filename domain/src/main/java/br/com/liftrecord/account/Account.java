package br.com.liftrecord.account;

import br.com.liftrecord.account.valueobjects.Password;
import br.com.liftrecord.core.DomainObject;
import br.com.liftrecord.student.AccountStatus;
import br.com.liftrecord.account.valueobjects.Contact;
import br.com.liftrecord.student.valueobjects.Address;
import br.com.liftrecord.visitor.Visitable;
import br.com.liftrecord.visitor.Visitor;
import jakarta.annotation.Nullable;
import java.time.LocalDate;
import java.util.Optional;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

@Getter
public class Account extends DomainObject<AccountId> implements Visitable<Account> {

  private final String name;
  @Nullable
  private AccountStatus status;
  private final Contact contact;
  @Nullable
  private final Password password;
  private final LocalDate birthDate;

  public Account(String name, String email, String cellphone, LocalDate birthDate, Address address) {
    this.name = name;
    this.contact = new Contact(email, cellphone);
    this.birthDate  = birthDate;
    this.password = null;
    this.status = null;
  }

  public Account(String id,
                 String name,
                 String email,
                 String cellphone,
                 String password,
                 AccountStatus status,
                 LocalDate birthDate) {
    super(AccountId.fromString(id));
    this.name = name;
    this.contact = new Contact(email, cellphone);
    this.password = new Password(password);
    this.status = status;
    this.birthDate = birthDate;
  }

  public void createAccount() {
    this.setId(new AccountId());
    this.status = AccountStatus.PENDING_ACTIVATION;
  }

  @Nullable
  public Optional<String> getPassword() {
    return Optional.ofNullable(ObjectUtils.defaultIfNull(password, new Password(null)).password());
  }

  @Override
  public void accept(Visitor<Account, ?> visitor) {
    visitor.visit(this);
  }

  @Override
  public String toString() {
    return "Account{" +
        "name='" + name + '\'' +
        ", status=" + status +
        ", contact=" + contact +
        ", password=" + password +
        "} " + super.toString();
  }

  public void inactivate() {
    this.status = AccountStatus.INACTIVE;
  }
}
