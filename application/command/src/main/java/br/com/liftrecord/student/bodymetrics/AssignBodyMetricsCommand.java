package br.com.liftrecord.student.bodymetrics;

import br.com.liftrecord.command.Command;
import br.com.liftrecord.dto.AssignBodyMetricsTransient;
import br.com.liftrecord.student.valueobjects.BodyMetrics;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

public record AssignBodyMetricsCommand(
    @Size(min = 26, max = 26)
    String studentId,
    @Positive
    Double weight,
    @Positive
    Double height,
    @Positive
    Double waistCircumference,
    @Positive
    Double abdomenCircumference,
    @Positive
    Double chestCircumference,
    @Positive
    Double armCircumference,
    @Positive
    Double thighCircumference,
    @Positive
    Double hipsCircumference,
    @Positive
    Double bmi,
    @Positive
    @Size(min = 1, max = 3)
    Double basalMetabolicRate
) implements Command, Serializable {

  @Serial
  private static final long serialVersionUID = 2966900717278696363L;

  public AssignBodyMetricsTransient toTransient() {
    return new AssignBodyMetricsTransient(
        this.studentId,
        new BodyMetrics(
            weight,
            height,
            waistCircumference,
            abdomenCircumference,
            chestCircumference,
            armCircumference,
            thighCircumference,
            hipsCircumference,
            bmi,
            basalMetabolicRate));
  }
}
