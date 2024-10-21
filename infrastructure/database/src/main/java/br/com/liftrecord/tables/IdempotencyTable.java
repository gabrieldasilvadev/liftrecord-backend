package br.com.liftrecord.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "idempotency")
public class IdempotencyTable {
  @Id
  private String key;
  private ZonedDateTime createdAt = ZonedDateTime.now();

  public IdempotencyTable(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setKey(String key) {
    this.key = key;
  }
}
