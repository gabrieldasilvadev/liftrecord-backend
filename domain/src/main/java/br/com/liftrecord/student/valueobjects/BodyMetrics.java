package br.com.liftrecord.student.valueobjects;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class BodyMetrics {
  private final Double weight;
  private final Double height;
  private final Double waistCircumference;
  private final Double abdomenCircumference;
  private final Double chestCircumference;
  private final Double armCircumference;
  private final Double thighCircumference;
  private final Double hipsCircumference;
  private final Double bmi;
  private final Double basalMetabolicRate;
  private boolean isCurrent;
  private LocalDate measurementDate;

  public BodyMetrics(Double weight,
                     Double height,
                     Double waistCircumference,
                     Double abdomenCircumference,
                     Double chestCircumference,
                     Double armCircumference,
                     Double thighCircumference,
                     Double hipsCircumference,
                     Double bmi,
                     Double basalMetabolicRate) {
    this.weight = weight;
    this.height = height;
    this.waistCircumference = waistCircumference;
    this.abdomenCircumference = abdomenCircumference;
    this.chestCircumference = chestCircumference;
    this.armCircumference = armCircumference;
    this.thighCircumference = thighCircumference;
    this.hipsCircumference = hipsCircumference;
    this.bmi = bmi;
    this.basalMetabolicRate = basalMetabolicRate;
  }

  public void setCurrent() {
    this.measurementDate = LocalDate.now();
    this.isCurrent = true;
  }
}
