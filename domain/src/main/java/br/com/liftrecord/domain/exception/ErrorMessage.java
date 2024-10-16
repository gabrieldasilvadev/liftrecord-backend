package br.com.liftrecord.domain.exception;

import java.io.Serial;
import java.io.Serializable;

public class ErrorMessage implements Serializable {

  @Serial
  private static final long serialVersionUID = -5851233664346981199L;
  private final String message;
  private final String description;

  private ErrorMessage(Builder builder) {
    message = builder.message;
    description = builder.description;
  }

  public static Builder builder(String message, String description) {
    return new Builder(message, description);
  }

  public String getMessage() {
    return message;
  }

  public String getDescription() {
    return description;
  }


  public static final class Builder {
    private final String message;
    private final String description;

    private Builder(String message, String description) {
      this.message = message;
      this.description = description;
    }

    public ErrorMessage build() {
      return new ErrorMessage(this);
    }
  }
}
