package br.com.liftrecord.student.bodymetrics.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.liftrecord.student.bodymetrics.AssignBodyMetricsCommand;
import org.springframework.stereotype.Component;

@Component
public class AssignBodyMetricsValidator extends AbstractValidator<AssignBodyMetricsCommand> {
  @Override
  public void rules() {
    ruleFor(AssignBodyMetricsCommand::studentId)
        .must(studentId -> studentId.length() == 26)
        .withCode("STUDENT_ID_INVALID_LENGTH")
        .withMessage("Student ID length must be 26")
        .withFieldName("studentId")
        .critical();

    ruleFor(AssignBodyMetricsCommand::weight)
        .must(weight -> weight > 0)
        .withCode("WEIGHT_INVALID")
        .withMessage("Weight must be greater than 0")
        .withFieldName("weight")
        .critical();

    ruleFor(AssignBodyMetricsCommand::height)
        .must(height -> height > 0)
        .withCode("HEIGHT_INVALID")
        .withMessage("Height must be greater than 0")
        .withFieldName("height")
        .critical();

    ruleFor(AssignBodyMetricsCommand::waistCircumference)
        .must(waistCircumference -> waistCircumference > 0)
        .withCode("WAIST_CIRCUMFERENCE_INVALID")
        .withMessage("Waist circumference must be greater than 0")
        .withFieldName("waistCircumference")
        .critical();

    ruleFor(AssignBodyMetricsCommand::abdomenCircumference)
        .must(abdomenCircumference -> abdomenCircumference > 0)
        .withCode("ABDOMEN_CIRCUMFERENCE_INVALID")
        .withMessage("Abdomen circumference must be greater than 0")
        .withFieldName("abdomenCircumference")
        .critical();

    ruleFor(AssignBodyMetricsCommand::chestCircumference)
        .must(chestCircumference -> chestCircumference > 0)
        .withCode("CHEST_CIRCUMFERENCE_INVALID")
        .withMessage("Chest circumference must be greater than 0")
        .withFieldName("chestCircumference")
        .critical();

    ruleFor(AssignBodyMetricsCommand::armCircumference)
        .must(armCircumference -> armCircumference > 0)
        .withCode("ARM_CIRCUMFERENCE_INVALID")
        .withMessage("Arm circumference must be greater than 0")
        .withFieldName("armCircumference")
        .critical();

    ruleFor(AssignBodyMetricsCommand::thighCircumference)
        .must(thighCircumference -> thighCircumference > 0)
        .withCode("THIGH_CIRCUMFERENCE_INVALID")
        .withMessage("Thigh circumference must be greater than 0")
        .withFieldName("thighCircumference")
        .critical();

    ruleFor(AssignBodyMetricsCommand::hipsCircumference)
        .must(hipsCircumference -> hipsCircumference > 0)
        .withCode("HIPS_CIRCUMFERENCE_INVALID")
        .withMessage("Hips circumference must be greater than 0")
        .withFieldName("hipsCircumference")
        .critical();

    ruleFor(AssignBodyMetricsCommand::bmi)
        .must(bmi -> bmi > 0)
        .withCode("BMI_INVALID")
        .withMessage("BMI must be greater than 0")
        .withFieldName("bmi")
        .critical();

    ruleFor(AssignBodyMetricsCommand::basalMetabolicRate)
        .must(basalMetabolicRate -> basalMetabolicRate > 0)
        .withCode("BASAL_METABOLIC_RATE_INVALID")
        .withMessage("Basal metabolic rate must be greater than 0")
        .withFieldName("basalMetabolicRate")
        .critical();
  }
}
