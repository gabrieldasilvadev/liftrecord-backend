package br.com.liftrecord.aop;

import br.com.liftrecord.annotations.IdempotencyControl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class IdempotencyControlAspect {
    private static final Logger logger = LoggerFactory.getLogger(IdempotencyControlAspect.class);

    // TODO - Injetar repository da tabela de idempotencia

    @Pointcut("@annotation(Idempotent)")
    public void idempotentMethod() {}

    @Around("idempotentMethod()")
    public Idempotency handleIdempotency(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        IdempotencyControl idempotencyAnnotation = signature.getMethod().getAnnotation(IdempotencyControl.class);

        // TODO - Implementar validacao de idempotencia apos consultar o banco de dados

        try {
            Object result = joinPoint.proceed();
            // TODO - salvar chave de idempotencia no banco de dados
            return new Idempotency(result.toString());
        } catch (Exception e) {
            logger.error("Error executing idempotent method", e);
            throw e;
        }
    }

}
