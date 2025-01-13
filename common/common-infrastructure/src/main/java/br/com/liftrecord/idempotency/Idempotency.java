package br.com.liftrecord.idempotency;

import java.time.ZonedDateTime;

public class Idempotency {
  private final String key;
  private ZonedDateTime createdAt;

  public Idempotency(String key) {
    this.key = key;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }
}
