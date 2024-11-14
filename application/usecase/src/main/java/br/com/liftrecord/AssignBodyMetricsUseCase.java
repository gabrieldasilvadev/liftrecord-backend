package br.com.liftrecord;

import br.com.liftrecord.dto.AssignBodyMetricsTransient;
import br.com.liftrecord.ports.student.StudentRepositoryOutputPort;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.student.valueobjects.BodyMetrics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignBodyMetricsUseCase implements UseCase<AssignBodyMetricsTransient, Student>{
  private final StudentRepositoryOutputPort studentRepositoryOutputPort;
  @Override
  public Student execute(AssignBodyMetricsTransient input) {
    BodyMetrics bodyMetrics = input.bodyMetrics();
    Student student = studentRepositoryOutputPort.findById(input.studentId()).orElseThrow();
    student.assignBodyMetrics(bodyMetrics);
    return studentRepositoryOutputPort.save(student);
  }
}
