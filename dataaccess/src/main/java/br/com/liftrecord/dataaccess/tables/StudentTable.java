package br.com.liftrecord.dataaccess.tables;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
  private String id;
  private String name;
  private String email;
  private String cellphone;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private AddressTable address;
  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<BodyMetricsTable> bodyMetrics;

  private StudentTable(Builder builder) {
    id = builder.id;
    name = builder.name;
    email = builder.email;
    cellphone = builder.cellphone;
  }

  public static Builder builder() {
    return new Builder();
  }


  public static final class Builder {
    private String id;
    private String name;
    private String email;
    private String cellphone;

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

    public StudentTable build() {
      return new StudentTable(this);
    }
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getCellphone() {
    return cellphone;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setCellphone(String cellphone) {
    this.cellphone = cellphone;
  }
}
