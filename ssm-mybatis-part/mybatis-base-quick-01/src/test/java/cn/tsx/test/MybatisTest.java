package cn.tsx.test;

import cn.tsx.mapper.EmployeeMapper;
import cn.tsx.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-22
 **/

public class MybatisTest {
    @Test
    public void test_01() throws IOException {
        //1.定义mybatis配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory工厂类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.开启sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.使用sqlSession得到mapper的动态代理对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println("employee = " + employee);
        //5.提交事务（非查询语句）
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }
}
