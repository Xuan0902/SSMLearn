package cn.tsx.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-21
 **/

@Component  //放入ioc容器
@Aspect //配置切面
public class LogAdvice {
    /*
    1.查询某包某类下，访问修饰符是公有，返回值是int的全部方法
    2.查询某包下类中第一个参数是String的方法
    3.查询全部包下，无参数的方法！
    4.查询com包下，以int参数类型结尾的方法
    5.查询指定包下，Service开头类的私有返回值int的无参数方法
    execution(public * *..*.*(int))
    execution(* *..*.*(String...))
    execution(* *..*.*())
    execution(* com..*.*(..,int))
    execution(private int cn.tsx.service.Service*.*())
     */
    //表示不考虑返回值，cn.tsx.service.impl包下的所有类中的所有方法，不考虑参数

    @Pointcut("execution(* cn.tsx.service.impl.CalculatorPureImpl.*(..))")
    public void pc(){}

    @Before("cn.tsx.pointcut.MyJointCut.pc()")
    public void start() {
        System.out.println("方法开始了");
    }

    @After("pc()")
    public void after() {
        System.out.println("方法结束啦");
    }

    @AfterThrowing("pc()")
    public void error() {
        System.out.println("方法报错了");
    }
}
