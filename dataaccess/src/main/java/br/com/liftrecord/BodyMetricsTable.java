package br.com.liftrecord;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "body_metrics")
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
}
