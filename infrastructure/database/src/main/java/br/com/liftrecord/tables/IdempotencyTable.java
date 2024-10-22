package br.com.liftrecord.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
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
@Table(name = "idempotency")
public class IdempotencyTable {
  @Id
  private String key;
  private ZonedDateTime createdAt = ZonedDateTime.now();

  public IdempotencyTable(String key) {
    this.key = key;
  }
}
