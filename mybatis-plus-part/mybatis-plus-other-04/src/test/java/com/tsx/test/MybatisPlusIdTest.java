package com.tsx.test;

import com.tsx.mapper.UserMapper;
import com.tsx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-30
 * @description:
 **/

@SpringBootTest
public class MybatisPlusIdTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void test() {
        User user = User.builder().name("张三").age(18).email("zhangsan@xx.com").build();
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }

    @Test
    void test_logicDelete() {
        // int row = userMapper.deleteById(1L);
        // System.out.println("row = " + row);
        List<User> users = userMapper.selectList(null);
        System.out.println("users = " + users);
    }
}
