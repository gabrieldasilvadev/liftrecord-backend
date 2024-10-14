package br.com.liftrecord.dataaccess.tables;

import java.time.ZonedDateTime;

public class IdempotencyTable {
  private String key;
  private final ZonedDateTime createdAt = ZonedDateTime.now();

  public IdempotencyTable() {
  }

  public IdempotencyTable(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }
}
