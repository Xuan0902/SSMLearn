package cn.tsx.test;

import cn.tsx.ioc_01.SpringConfiguration;
import cn.tsx.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

public class SpringIocTest {
    @Test
    public void iocTest1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        StudentController bean = context.getBean(StudentController.class);
        System.out.println("bean = " + bean);
    }
}
