package com.tsx.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@Component
@Aspect
public class LogAdvice {
    @Before("execution(* com.tsx.service.UserService.*(..))")
    public void before(JoinPoint joinPoint) {
        String classname = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println("classname = " + classname);
        String methodName = joinPoint.getSignature().getName();
        System.out.println("methodName = " + methodName);
    }
}
