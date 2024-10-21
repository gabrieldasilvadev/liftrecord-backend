package br.com.liftrecord.tables;

import br.com.liftrecord.student.AccountStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentTable {
  @Id
  private String id;
  private String name;
  @Column(unique = true)
  private String email;
  @Column(unique = true)
  private String cellphone;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id")
  private AddressTable address;
  @Column(name = "body_metrics")
  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<BodyMetricsTable> bodyMetrics;
  @Enumerated(EnumType.STRING)
  private AccountStatus status;

  public StudentTable() {
  }

  public StudentTable(String id,
                      String name,
                      String email,
                      String cellphone,
                      AddressTable address,
                      List<BodyMetricsTable> bodyMetrics,
                      AccountStatus status) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.cellphone = cellphone;
    this.address = address;
    this.bodyMetrics = bodyMetrics;
    this.status = status;
  }

  private StudentTable(Builder builder) {
    setId(builder.id);
    setName(builder.name);
    setEmail(builder.email);
    setCellphone(builder.cellphone);
    setAddress(builder.address);
    setBodyMetrics(builder.bodyMetrics);
    setStatus(builder.status);
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCellphone() {
    return cellphone;
  }

  public void setCellphone(String cellphone) {
    this.cellphone = cellphone;
  }

  public AddressTable getAddress() {
    return address;
  }

  public void setAddress(AddressTable address) {
    this.address = address;
  }

  public List<BodyMetricsTable> getBodyMetrics() {
    return bodyMetrics;
  }

  public void setBodyMetrics(List<BodyMetricsTable> bodyMetrics) {
    this.bodyMetrics = bodyMetrics;
  }

  public AccountStatus getStatus() {
    return status;
  }

  public void setStatus(AccountStatus status) {
    this.status = status;
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
