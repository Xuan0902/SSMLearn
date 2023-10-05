package cn.tsx.test;

import cn.tsx.mapper.UserMapper;
import cn.tsx.pojo.User;
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

/**
 * author: Xuan
 * <p>
 * create: 2023-09-23
 **/

public class MyBatisTest {
    private SqlSession session;

    @BeforeEach
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sqlSessionFactory.openSession(true);
    }

    @Test
    public void test() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = User.builder().username("张三").password("123456").build();
        System.out.println(user.getId());
        int insert = mapper.insert(user);
        System.out.println(user.getId());
        System.out.println("insert = " + insert);
        // int update = mapper.update(User.builder().id(1).username("李四").password("654321").build());
        // System.out.println("update = " + update);
        // User user = mapper.selectById(1);
        // System.out.println("user = " + user);
        // int delete = mapper.delete(1);
        // System.out.println("delete = " + delete);
        // List<User> users = mapper.selectAll();
        // System.out.println("users = " + users);
    }

    @AfterEach
    public void after() {
        session.close();
    }
}
