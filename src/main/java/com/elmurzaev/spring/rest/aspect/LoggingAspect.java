package com.elmurzaev.spring.rest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.elmurzaev.spring.rest.dao.*.*(..))")
    public void allRepositoryMethods(){

    }

    @Around("allRepositoryMethods()")
    public Object aroundAllRepositoryMethodsLoggingAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Begin of " + methodName);
        Object targetMethodResult = joinPoint.proceed();
        System.out.println("End of " + methodName);
        return targetMethodResult;
    }
}
