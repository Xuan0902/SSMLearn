package cn.tsx.controller;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    @Test
    void findAll() {
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("spring-01.xml");
        StudentController bean = context.getBean(StudentController.class);
        bean.findAll();
    }
}