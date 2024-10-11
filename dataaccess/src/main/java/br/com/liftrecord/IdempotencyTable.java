package br.com.liftrecord;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.ZonedDateTime;

@Entity(name = "idempotency")
public class IdempotencyTable {
    @Id
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
