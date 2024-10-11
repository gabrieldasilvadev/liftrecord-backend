package br.com.liftrecord;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "address")
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
}
