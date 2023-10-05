package cn.tsx.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-21
 **/

@Aspect
@Component
public class MyAdvice {
    @Before("cn.tsx.pointcut.MyJointCut.myPc()")
    public void before(JoinPoint joinPoint) {
        //获取类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        //获取方法的信息
        String name = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("args = " + Arrays.toString(args));
        System.out.println("name = " + name);
        System.out.println("simpleName = " + simpleName);
    }

    @AfterReturning(value = "execution(* cn..impl.*.*(..)))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("result = " + result);
    }

    @After("execution(* cn..impl.*.*(..)))")
    public void after() {

    }

    @AfterThrowing(value = "execution(* cn..impl.*.*(..)))", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("throwable = " + throwable);
    }
}
