package cn.tsx.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-21
 **/

@Component
public class MyJointCut {
    @Pointcut("execution(* cn.tsx.service.impl.CalculatorPureImpl.*(..))")
    public void pc(){}

    @Pointcut("execution(* cn..impl.*.*(..))")
    public void myPc(){}
}
