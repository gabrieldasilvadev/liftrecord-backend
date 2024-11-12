package br.com.liftrecord.student;

import br.com.liftrecord.openapi.model.AssignBodyMetricsRequestDto;
import br.com.liftrecord.student.bodymetrics.AssignBodyMetricsCommand;

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
}
