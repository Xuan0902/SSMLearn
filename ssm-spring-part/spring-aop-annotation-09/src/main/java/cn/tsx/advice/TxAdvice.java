package cn.tsx.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-21
 **/

@Aspect
@Component
public class TxAdvice {
    @Before("cn.tsx.pointcut.MyJointCut.pc()")
    public void begin() {
        System.out.println("开启事务");
    }

    @AfterReturning("cn.tsx.pointcut.MyJointCut.pc()")
    public void commit() {
        System.out.println("事务提交");
    }

    @AfterThrowing("cn.tsx.pointcut.MyJointCut.pc()")
    public void rollback() {
        System.out.println("事务回滚");
    }
}
