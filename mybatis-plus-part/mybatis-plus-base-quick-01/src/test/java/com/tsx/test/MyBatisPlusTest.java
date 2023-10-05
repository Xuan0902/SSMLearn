package com.tsx.test;

import com.tsx.mapper.UserMapper;
import com.tsx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-29
 * @description: mybatis-plus的测试类
 **/

@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void test(){
        List<User> users = userMapper.selectList(null);
        System.out.println("users = " + users);
    }
}
