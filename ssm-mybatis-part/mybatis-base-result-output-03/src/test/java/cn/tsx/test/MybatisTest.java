package cn.tsx.test;


import cn.tsx.mapper.EmployeeMapper;
import cn.tsx.mapper.TeacherMapper;
import cn.tsx.pojo.Employee;
import cn.tsx.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-23
 **/

public class MybatisTest {
    private SqlSession session;

    // @BeforeEach
    @BeforeEach
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sqlSessionFactory.openSession(true);  // 自动开启事务，自动提交事务
    }

    /*
    自增长主键回填
     */
    @Test
    public void test_01() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("二狗子");
        employee.setEmpSalary(888.0);
        int rows = employeeMapper.insertEmp(employee);
        System.out.println("rows = " + rows);
    }

    /*
    非自增长主键回填
     */
    @Test
    public void test_02() {
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        // teacher.setTId(UUID.randomUUID().toString().replaceAll("-", ""));
        System.out.println(teacher.getTId());
        teacher.setTName("老师");
        int rows = mapper.insertTeacher(teacher);
        System.out.println(teacher.getTId());
        System.out.println("rows = " + rows);
    }

    @AfterEach
    public void after() {
        session.commit();
        session.close();
    }
}
