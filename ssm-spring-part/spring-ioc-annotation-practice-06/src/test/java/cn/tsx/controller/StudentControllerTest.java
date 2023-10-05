package cn.tsx.controller;

import cn.tsx.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


class StudentControllerTest {
    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentController bean = context.getBean(StudentController.class);
        bean.findAll();
    }

}