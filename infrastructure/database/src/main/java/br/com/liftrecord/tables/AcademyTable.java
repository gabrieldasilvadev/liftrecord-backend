package br.com.liftrecord.tables;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "academy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademyTable {
  @Id
  private String id;
  private String name;
  private String document;
  private String cellphone;
  private String email;
  @OneToOne
  @JoinColumn(name = "address_id", nullable = false)
  private AddressTable address;
  @OneToMany(mappedBy = "academy", cascade = CascadeType.ALL)
  private List<StudentTable> students;
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
}
