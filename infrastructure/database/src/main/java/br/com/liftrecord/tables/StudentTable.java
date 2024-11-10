package br.com.liftrecord.tables;

import br.com.liftrecord.account.valueobjects.Contact;
import br.com.liftrecord.student.Student;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentTable {
  @Id
  private String id;
  @Column(name = "body_metrics")
  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<BodyMetricsTable> bodyMetrics;
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "account_id", referencedColumnName = "id")
  private AccountTable account;
  @ManyToOne
  @JoinColumn(name = "academy_id", referencedColumnName = "id")
  private AcademyTable academy;

  public StudentTable fromDomain(Student student) {
    return StudentTable.builder()
        .id(student.getId().getValue())
        .account(AccountTable.fromDomain(student.getAccount()))
        .academy(null)
        .bodyMetrics(null)
        .build();
  }

  public Student toDomain() {
    return Student.builder()
        .name(this.account.getName())
        .contact(new Contact(this.account.getEmail(), this.account.getCellphone()))
        .account(this.account.toDomain())
        .bodyMetrics(this.bodyMetrics.stream().map(BodyMetricsTable::toDomain).toList())
        .build();
  }
}
