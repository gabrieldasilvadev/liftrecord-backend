package br.com.liftrecord.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

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

  public boolean isCurrent() {
    return isCurrent;
  }

  public BodyMetricsTable() {
  }

  public BodyMetricsTable(String id,
                          Double weight,
                          Double height,
                          Double waistCircumference,
                          Double abdomenCircumference,
                          Double chestCircumference,
                          Double armCircumference,
                          Double thighCircumference,
                          Double hipsCircumference,
                          Double bmi,
                          Double basalMetabolicRate,
                          LocalDate measurementDate,
                          boolean isCurrent,
                          StudentTable student) {
    this.id = id;
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
    this.measurementDate = measurementDate;
    this.isCurrent = isCurrent;
    this.student = student;
  }

  public void setCurrent(boolean current) {
    isCurrent = current;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public Double getWaistCircumference() {
    return waistCircumference;
  }

  public void setWaistCircumference(Double waistCircumference) {
    this.waistCircumference = waistCircumference;
  }

  public Double getAbdomenCircumference() {
    return abdomenCircumference;
  }

  public void setAbdomenCircumference(Double abdomenCircumference) {
    this.abdomenCircumference = abdomenCircumference;
  }

  public Double getChestCircumference() {
    return chestCircumference;
  }

  public void setChestCircumference(Double chestCircumference) {
    this.chestCircumference = chestCircumference;
  }

  public Double getArmCircumference() {
    return armCircumference;
  }

  public void setArmCircumference(Double armCircumference) {
    this.armCircumference = armCircumference;
  }

  public Double getThighCircumference() {
    return thighCircumference;
  }

  public void setThighCircumference(Double thighCircumference) {
    this.thighCircumference = thighCircumference;
  }

  public Double getHipsCircumference() {
    return hipsCircumference;
  }

  public void setHipsCircumference(Double hipsCircumference) {
    this.hipsCircumference = hipsCircumference;
  }

  public Double getBmi() {
    return bmi;
  }

  public void setBmi(Double bmi) {
    this.bmi = bmi;
  }

  public Double getBasalMetabolicRate() {
    return basalMetabolicRate;
  }

  public void setBasalMetabolicRate(Double basalMetabolicRate) {
    this.basalMetabolicRate = basalMetabolicRate;
  }

  public LocalDate getMeasurementDate() {
    return measurementDate;
  }

  public void setMeasurementDate(LocalDate measurementDate) {
    this.measurementDate = measurementDate;
  }

  public StudentTable getStudent() {
    return student;
  }

  public void setStudent(StudentTable student) {
    this.student = student;
  }
}
