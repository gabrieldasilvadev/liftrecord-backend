package br.com.liftrecord.tables;

import de.huxhorn.sulky.ulid.ULID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "address")
public class AddressTable {
  @Id
  private String id;
  private String state;
  private String city;
  private String neighborhood;
  private String street;
  private String number;
  private String complement;
  @Column(name = "zip_code")
  private String zipCode;
  @OneToOne(mappedBy = "address")
  private StudentTable student;

  public AddressTable() {
  }

  private AddressTable(Builder builder) {
    if(Objects.isNull(this.getId())) {
      this.id = new ULID().nextULID();
    }
    state = builder.state;
    city = builder.city;
    neighborhood = builder.neighborhood;
    street = builder.street;
    number = builder.number;
    complement = builder.complement;
    zipCode = builder.zipCode;
    student = builder.student;
  }

  public static Builder builder() {
    return new Builder();
  }


  public static final class Builder {
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
    private String complement;
    private String zipCode;
    private StudentTable student;

    private Builder() {
    }

    public Builder state(String val) {
      state = val;
      return this;
    }

    public Builder city(String val) {
      city = val;
      return this;
    }

    public Builder neighborhood(String val) {
      neighborhood = val;
      return this;
    }

    public Builder street(String val) {
      street = val;
      return this;
    }

    public Builder number(String val) {
      number = val;
      return this;
    }

    public Builder complement(String val) {
      complement = val;
      return this;
    }

    public Builder zipCode(String val) {
      zipCode = val;
      return this;
    }

    public Builder student(StudentTable val) {
      student = val;
      return this;
    }

    public AddressTable build() {
      return new AddressTable(this);
    }
  }

  public String getId() {
    return id;
  }

  public String getState() {
    return state;
  }

  public String getCity() {
    return city;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public String getStreet() {
    return street;
  }

  public String getNumber() {
    return number;
  }

  public String getComplement() {
    return complement;
  }

  public String getZipCode() {
    return zipCode;
  }

  public StudentTable getStudent() {
    return student;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public void setStudent(StudentTable student) {
    this.student = student;
  }
}
