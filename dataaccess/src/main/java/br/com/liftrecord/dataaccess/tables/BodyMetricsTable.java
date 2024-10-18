package br.com.liftrecord.dataaccess.tables;

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

  public BodyMetricsTable() {
  }

  public String getId() {
    return id;
  }

  public Double getWeight() {
    return weight;
  }

  public Double getHeight() {
    return height;
  }

  public Double getWaistCircumference() {
    return waistCircumference;
  }

  public Double getAbdomenCircumference() {
    return abdomenCircumference;
  }

  public Double getChestCircumference() {
    return chestCircumference;
  }

  public Double getArmCircumference() {
    return armCircumference;
  }

  public Double getThighCircumference() {
    return thighCircumference;
  }

  public Double getHipsCircumference() {
    return hipsCircumference;
  }

  public Double getBmi() {
    return bmi;
  }

  public Double getBasalMetabolicRate() {
    return basalMetabolicRate;
  }

  public void setBasalMetabolicRate(Double basalMetabolicRate) {
    this.basalMetabolicRate = basalMetabolicRate;
  }

  public void setBmi(Double bmi) {
    this.bmi = bmi;
  }

  public void setHipsCircumference(Double hipsCircumference) {
    this.hipsCircumference = hipsCircumference;
  }

  public void setThighCircumference(Double thighCircumference) {
    this.thighCircumference = thighCircumference;
  }

  public void setArmCircumference(Double armCircumference) {
    this.armCircumference = armCircumference;
  }

  public void setChestCircumference(Double chestCircumference) {
    this.chestCircumference = chestCircumference;
  }

  public void setAbdomenCircumference(Double abdomenCircumference) {
    this.abdomenCircumference = abdomenCircumference;
  }

  public void setWaistCircumference(Double waistCircumference) {
    this.waistCircumference = waistCircumference;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isCurrent() {
    return isCurrent;
  }

  public void setCurrent(boolean current) {
    isCurrent = current;
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