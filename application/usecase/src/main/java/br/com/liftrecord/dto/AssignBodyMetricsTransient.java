package br.com.liftrecord.dto;

import br.com.liftrecord.student.valueobjects.BodyMetrics;

public record AssignBodyMetricsTransient(
    String studentId,
    BodyMetrics bodyMetrics
) {
}
