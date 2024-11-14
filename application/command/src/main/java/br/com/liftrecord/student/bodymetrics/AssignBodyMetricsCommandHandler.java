package br.com.liftrecord.student.bodymetrics;

import br.com.liftrecord.AssignBodyMetricsUseCase;
import br.com.liftrecord.Log5WBuilder;
import br.com.liftrecord.command.CommandHandler;
import br.com.liftrecord.exception.ObjectStateException;
import br.com.liftrecord.student.Student;
import br.com.liftrecord.student.bodymetrics.validator.AssignBodyMetricsValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignBodyMetricsCommandHandler implements CommandHandler<AssignBodyMetricsCommand, Student> {
  private final AssignBodyMetricsValidator  assignBodyMetricsValidator;
  private final AssignBodyMetricsUseCase assignBodyMetricsUseCase;
  private final Logger logger = LoggerFactory.getLogger(AssignBodyMetricsCommandHandler.class);

  @Override
  public Student handle(@Valid AssignBodyMetricsCommand command) {
    Log5WBuilder
        .method()
        .logCode("ABMCH-HDL-01")
        .whatHappen("Assigning body metrics to student")
        .addInfo("STUDENT_ID", command.studentId())
        .addInfo("BODY_METRICS", command.toString())
        .info(logger);
    assignBodyMetricsValidator.validate(command).isInvalidThrow(ObjectStateException.class);
    final Student student = assignBodyMetricsUseCase.execute(command.toTransient());
    Log5WBuilder
        .method()
        .logCode("ABMCH-HDL-02")
        .whatHappen("Body metrics assigned successfully")
        .addInfo("STUDENT_ID", command.studentId())
        .addInfo("BODY_METRICS", StringUtils.join(student.getBodyMetrics()))
        .info(logger);
    return null;
  }

  @Override
  public Class<AssignBodyMetricsCommand> getCommandType() {
    return AssignBodyMetricsCommand.class;
  }

  @Override
  public boolean canHandle(AssignBodyMetricsCommand command) {
    return command.studentId().length() == 26;
  }
}
