package br.com.liftrecord.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
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
@Table(name = "body_metrics")
public class BodyMetricsTable {
  @Id
  private String id;
  private Double weight;
  private Double height;
  private Double waistCircumference;
  private Double abdomenCircumference;
  private Double chestCircumference;
  private Double armCircumference;
  private Double thighCircumference;
  private Double hipsCircumference;
  private Double bmi;
  private Double basalMetabolicRate;
  private LocalDate measurementDate;
  @Column(name = "is_current", nullable = false)
  private boolean isCurrent;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id", nullable = false)
  private StudentTable student;
}
