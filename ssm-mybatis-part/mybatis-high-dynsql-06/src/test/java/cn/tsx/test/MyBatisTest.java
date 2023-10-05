package cn.tsx.test;

import cn.tsx.mapper.EmployeeMapper;
import cn.tsx.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-23
 * @description: 动态语句测试
 **/

public class MyBatisTest {
    private SqlSession session;

    @BeforeEach
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sqlSessionFactory.openSession(true);
    }

    @Test
    public void test() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("二狗子");
        employee.setEmpSalary(200D);
        int rows = mapper.insertBatch(Arrays.asList(employee, employee, employee));
        System.out.println("rows = " + rows);
    }

    @AfterEach
    public void clean() {
        session.close();
    }
}
