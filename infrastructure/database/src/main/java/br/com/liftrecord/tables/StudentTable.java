package br.com.liftrecord.tables;

import br.com.liftrecord.student.valueobjects.BodyMetrics;
import br.com.liftrecord.valueobjects.Contact;
import br.com.liftrecord.student.Student;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
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
  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  @MapKey(name = "measurementDate") // Define `measurementDate` como chave do Map
  private Map<LocalDate, BodyMetricsTable> bodyMetrics = new HashMap<>();
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "account_id", referencedColumnName = "id")
  private AccountTable account;
  @ManyToOne
  @JoinColumn(name = "academy_id", referencedColumnName = "id")
  private AcademyTable academy;

  public StudentTable fromDomain(Student student) {
    Map<LocalDate, BodyMetricsTable> metricsMap = student.getBodyMetrics().entrySet().stream()
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            entry -> BodyMetricsTable.fromDomain(entry.getValue())
        ));

    return StudentTable.builder()
        .id(student.getId().getValue())
        .account(AccountTable.fromDomain(student.getAccount()))
        .academy(null)
        .bodyMetrics(metricsMap)
        .build();
  }

  public Student toDomain() {
    Map<LocalDate, BodyMetrics> domainMetrics = this.bodyMetrics.entrySet().stream()
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            entry -> entry.getValue().toDomain()
        ));

    return Student.builder()
        .name(this.account.getName())
        .contact(new Contact(this.account.getEmail(), this.account.getCellphone()))
        .account(this.account.toDomain())
        .bodyMetrics(domainMetrics)
        .build();
  }
}
