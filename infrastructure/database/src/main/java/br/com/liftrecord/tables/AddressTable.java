package br.com.liftrecord.tables;

import br.com.liftrecord.student.valueobjects.Address;
import de.huxhorn.sulky.ulid.ULID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
  private AccountTable student;

  public AddressTable fromDomain(Address address) {
    return AddressTable.builder()
        .id(new ULID().nextULID())
        .street(address.street())
        .number(address.number())
        .neighborhood(address.neighborhood())
        .complement(address.complement())
        .city(address.city())
        .state(address.state())
        .zipCode(address.zipCode())
        .build();
  }
}
