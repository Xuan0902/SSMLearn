package cn.tsx.test;

import cn.tsx.mapper.EmployeeMapper;
import cn.tsx.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MybatisTest {
    private SqlSession sqlSession;

    @BeforeEach
    void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    // 使用分页插件
    @Test
    void test() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        // 调用之前，先设置分页数据（当前是第几页，每页有几条数据）
        PageHelper.startPage(1, 2);  // 第1页，每页2条数据
        List<Employee> list = mapper.queryList();
        // 将查询到的数据风封装到一个PageInfo的分页实体类对象（一共有多少页，一共有多少条）
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        // PageInfo中可以得到不同数据
        // 分页数据
        List<Employee> pageInfoList = pageInfo.getList();
        System.out.println("pageInfoList = " + pageInfoList);
        // 总页数
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        // 总条数
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);

        System.out.println("list = " + list);

    }

    @AfterEach
    void after() {
        sqlSession.close();
    }

}