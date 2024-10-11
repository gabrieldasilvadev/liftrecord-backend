package br.com.liftrecord.entities.student.valueobjects;

public class BodyMetrics {
    final Double weight;
    final Double height;
    final Double waistCircumference;
    final Double abdomenCircumference;
    final Double chestCircumference;
    final Double armCircumference;
    final Double thighCircumference;
    final Double hipsCircumference;
    final Double bmi;
    final Double basalMetabolicRate;

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
}
