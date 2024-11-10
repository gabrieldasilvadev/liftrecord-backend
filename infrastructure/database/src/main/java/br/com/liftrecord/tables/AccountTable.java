package br.com.liftrecord.tables;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.student.AccountStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountTable {
  @Id
  private String id;
  @Column(nullable = false)
  private String name;
  @Column(unique = true)
  private String email;
  @Column(unique = true)
  private String cellphone;
  private String password;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private AccountStatus status;
  @OneToOne(mappedBy = "account", orphanRemoval = true, cascade = CascadeType.ALL)
  private StudentTable student;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", nullable = false)
  private AddressTable address;
  private LocalDate birthDate;

  public AccountTable(Account account) {
    this.id = account.getId().getValue();
    this.name = account.getName();
    this.email = Objects.requireNonNull(account.getContact().getEmail()).getValue();
    this.cellphone = Objects.requireNonNull(account.getContact().getCellphone()).getFullNumber();
    this.password = Objects.requireNonNull(account.getPassword()).orElse(null);
    this.status = account.getStatus();
    this.birthDate = account.getBirthDate();
  }

  public Account toDomain() {
    return new Account(id, name, email, cellphone, password, status, birthDate);
  }
}
