package br.com.liftrecord.dataaccess.tables;

import br.com.liftrecord.domain.student.AccountStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentTable {

  @Id
  private final String id;
  private String name;
  @Column(unique = true)
  private String email;
  @Column(unique = true)
  private String cellphone;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private AddressTable address;
  @Column(name = "body_metrics")
  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<BodyMetricsTable> bodyMetrics;
  @Enumerated(EnumType.STRING)
  private AccountStatus status;

  private StudentTable(Builder builder) {
    id = builder.id;
    name = builder.name;
    email = builder.email;
    cellphone = builder.cellphone;
    address = builder.address;
    bodyMetrics = builder.bodyMetrics;
    status = builder.status;
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getId() {
    return id;
  }


  public static final class Builder {
    private String id;
    private String name;
    private String email;
    private String cellphone;
    private AddressTable address;
    private List<BodyMetricsTable> bodyMetrics;
    private AccountStatus status;

    private Builder() {
    }

    public Builder id(String val) {
      id = val;
      return this;
    }

    public Builder name(String val) {
      name = val;
      return this;
    }

    public Builder email(String val) {
      email = val;
      return this;
    }

    public Builder cellphone(String val) {
      cellphone = val;
      return this;
    }

    public Builder address(AddressTable val) {
      address = val;
      return this;
    }

    public Builder bodyMetrics(List<BodyMetricsTable> val) {
      bodyMetrics = val;
      return this;
    }

    public Builder status(AccountStatus val) {
      status = val;
      return this;
    }

    public StudentTable build() {
      return new StudentTable(this);
    }
  }
}
