package br.com.liftrecord.dataaccess.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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
  private String zipCode;
  @OneToOne(mappedBy = "address")
  private StudentTable student;

  public AddressTable() {
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
}
