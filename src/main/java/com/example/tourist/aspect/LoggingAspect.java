package com.example.tourist.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(com.example.tourist.controller.*)")
    public void controllers(){

    }

    @Pointcut("within(com.example.tourist.service.impl.*)")
    public void services(){

    }

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
