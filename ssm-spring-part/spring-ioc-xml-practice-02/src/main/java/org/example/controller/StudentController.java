package org.example.controller;

import org.example.pojo.Student;
import org.example.service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void queryAll() {
        List<Student> studentList = studentService.queryAll();
        System.out.println("controller的queryAll得到的list" + studentList);
    }
}
