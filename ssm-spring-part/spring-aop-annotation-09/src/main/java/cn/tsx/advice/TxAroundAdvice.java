package cn.tsx.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-21
 **/

@Component
@Aspect
public class TxAroundAdvice {
    @Around(value = "cn.tsx.pointcut.MyJointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            result = joinPoint.proceed(args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
