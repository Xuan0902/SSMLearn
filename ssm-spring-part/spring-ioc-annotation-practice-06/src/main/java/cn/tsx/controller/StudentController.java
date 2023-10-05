package cn.tsx.controller;

import cn.tsx.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    public void findAll() {
        System.out.println(studentService.findAll());
    }
}
