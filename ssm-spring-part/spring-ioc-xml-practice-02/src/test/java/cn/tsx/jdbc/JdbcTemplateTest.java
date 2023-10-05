package cn.tsx.jdbc;

import org.example.controller.StudentController;
import org.example.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void testForIoc() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        /**
         * 查询单条
         */
        String sql = "select * from students where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Student student1 = new Student();
            student1.setId(rs.getInt("id"));
            student1.setAge(rs.getInt("age"));
            student1.setName(rs.getString("name"));
            student1.setGender(rs.getString("gender"));
            student1.setClasses(rs.getString("class"));
            return student1;
        }, 1);
        System.out.println(student);

        /*
        查询所有学生数据
         */
        sql = "select id, name, gender, age, class as classes from students";
        List<Student> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println(query);
    }

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");
        StudentController bean = context.getBean(StudentController.class);
        bean.queryAll();
    }
}
