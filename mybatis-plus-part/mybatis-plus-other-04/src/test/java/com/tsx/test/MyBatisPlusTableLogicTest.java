package com.tsx.test;

import com.tsx.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: ShengXuan
 * @create: 2023-09-30
 * @description: 测试逻辑删除
 **/
@SpringBootTest
public class MyBatisPlusTableLogicTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void test() {
        int i = userMapper.deleteById(1L);
        System.out.println("i = " + i);
    }
}
