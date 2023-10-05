package org.example.service.impl;

import org.example.dao.StudentDao;
import org.example.pojo.Student;
import org.example.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> queryAll() {
        return studentDao.queryAll();
    }
}
