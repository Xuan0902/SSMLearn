package com.tsx.controller;

import com.tsx.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@RestController
@RequestMapping("stu")
public class StudentController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("list")
    public List<Student> list() {
        String sql = "select * from students";
        List<Student> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("query = " + query);
        return query;
    }
}
