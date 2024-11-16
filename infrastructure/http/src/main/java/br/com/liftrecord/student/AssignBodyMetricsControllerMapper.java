package br.com.liftrecord.student;

import br.com.liftrecord.core.DomainObject;
import br.com.liftrecord.openapi.model.AssignBodyMetricsRequestDto;
import br.com.liftrecord.openapi.model.AssignBodyMetricsResponseDto;
import br.com.liftrecord.student.bodymetrics.AssignBodyMetricsCommand;
import br.com.liftrecord.student.valueobjects.BodyMetrics;
import java.time.LocalDate;
import org.springframework.http.ResponseEntity;

public class AssignBodyMetricsControllerMapper {
  public static AssignBodyMetricsCommand toCommand(String studentId,
                                                   AssignBodyMetricsRequestDto assignBodyMetricsRequestDto) {
    return new AssignBodyMetricsCommand(
        studentId,
        assignBodyMetricsRequestDto.getWeight(),
        assignBodyMetricsRequestDto.getHeight(),
        assignBodyMetricsRequestDto.getWaistCircumference(),
        assignBodyMetricsRequestDto.getAbdomenCircumference(),
        assignBodyMetricsRequestDto.getChestCircumference(),
        assignBodyMetricsRequestDto.getArmCircumference(),
        assignBodyMetricsRequestDto.getThighCircumference(),
        assignBodyMetricsRequestDto.getHipsCircumference(),
        assignBodyMetricsRequestDto.getBmi(),
        assignBodyMetricsRequestDto.getBasalMetabolicRate());
  }

  public static AssignBodyMetricsResponseDto toResponse(Student student) {
    final BodyMetrics currentBodyMetrics = student.getBodyMetrics().get(LocalDate.now());
    return AssignBodyMetricsResponseDto.builder()
        .weight(currentBodyMetrics.getWeight())
        .height(currentBodyMetrics.getHeight())
        .waistCircumference(currentBodyMetrics.getWaistCircumference())
        .abdomenCircumference(currentBodyMetrics.getAbdomenCircumference())
        .chestCircumference(currentBodyMetrics.getChestCircumference())
        .armCircumference(currentBodyMetrics.getArmCircumference())
        .thighCircumference(currentBodyMetrics.getThighCircumference())
        .hipsCircumference(currentBodyMetrics.getHipsCircumference())
        .bmi(currentBodyMetrics.getBmi())
        .basalMetabolicRate(currentBodyMetrics.getBasalMetabolicRate())
        .build();
  }
}
