package br.com.liftrecord.dataaccess;

import jakarta.persistence.Entity;

@Entity
public class BodyMetricsTable {
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
