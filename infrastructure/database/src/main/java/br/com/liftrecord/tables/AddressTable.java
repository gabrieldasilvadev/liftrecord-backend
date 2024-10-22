package br.com.liftrecord.tables;

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
  private StudentTable student;
}
