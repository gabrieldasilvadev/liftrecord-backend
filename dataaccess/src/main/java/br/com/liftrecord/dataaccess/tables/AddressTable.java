package br.com.liftrecord.dataaccess.tables;

import jakarta.persistence.Entity;

@Entity
public class AddressTable {
  private String id;
  private String state;
  private String city;
  private String neighborhood;
  private String street;
  private String number;
  private String complement;
  private String zipCode;
}
