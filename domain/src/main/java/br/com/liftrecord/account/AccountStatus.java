package br.com.liftrecord.account;

public enum AccountStatus {
  ACTIVE("active"),
  PENDING_ACTIVATION("pending_activation"),
  INACTIVE("inactive");

  private final String status;

  AccountStatus(String status) {
    this.status = status;
  }

  public boolean isActive() {
    return this == ACTIVE;
  }

  public boolean isPending() {
    return this == PENDING_ACTIVATION;
  }

  public boolean isInactive() {
    return this == INACTIVE;
  }

  public static AccountStatus fromString(String status) {
    return switch (status.toUpperCase()) {
      case "ACTIVE" -> ACTIVE;
      case "INACTIVE" -> INACTIVE;
      case "PENDING_ACTIVATION" -> PENDING_ACTIVATION;
      default -> throw new IllegalArgumentException("Invalid account status: " + status);
    };
  }

  public String getValue() {
    return this.status;
  }

  @Override
  public String toString() {
    return this.name();
  }
}
