package br.com.liftrecord;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExceptionAspect {

  private static final Logger logger = LoggerFactory.getLogger(LogExceptionAspect.class);

  @Around("@annotation(LogException)")
  public Object aroundAspectHandler(ProceedingJoinPoint joinPoint) throws Throwable {
    Object result;
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    try {
      result = joinPoint.proceed();
    } catch (Exception ex) {
      Log5WBuilder
          .method()
          .logCode("LEA-AAH-ERROR")
          .whatHappen("Exception occurred during method execution")
          .addInfo("method", joinPoint.getSignature().toShortString())
          .addInfo("arguments", objectMapper.writeValueAsString(joinPoint.getArgs()))
          .addInfo("exception_message", ex.getMessage())
          .error(logger, ex);
      throw ex;
    }
    return result;
  }
}
