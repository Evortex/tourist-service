package com.example.tourist.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Аспект для логирования входящих запросов и исходящих ответов в контроллерах и сервисах.
 * Использует Aspect-Oriented Programming (AOP) для перехвата выполнения методов
 * и логирования информации о запросах и результатах.
 */
@Aspect
@Component
public class LoggingAspect {
    // Логгер для записи логов
    Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * Точка среза для методов в контроллерах.
     */
    @Pointcut("within(com.example.tourist.controller.*)")
    public void controllers(){
        // Пустой метод, используемый для пометки точки среза
    }

    /**
     * Точка среза для методов в сервисах.
     */
    @Pointcut("within(com.example.tourist.service.impl.*)")
    public void services(){
        // Пустой метод, используемый для пометки точки среза
    }

    /**
     * Метод, который перехватывает выполнение методов в контроллерах и сервисах,
     * логирует информацию о запросах и ответах, а также время выполнения.
     *
     * @param joinPoint точка выполнения, предоставляющая информацию о текущем методе
     * @return результат выполнения перехваченного метода
     * @throws Throwable если метод выбрасывает исключение, оно будет передано
     */
    @Around("services() || controllers()")
    public Object loggingRequestAndResponseReturnRespEntity(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        log.info("Enter: {}.{}() with arguments: {}",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed();

        log.info("Exit: {}.{}() with result: {}",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName(),
                result);

        long duration = System.currentTimeMillis() - startTime;
        log.info("Execution time: {} ms", duration);

        return result;
    }
}
