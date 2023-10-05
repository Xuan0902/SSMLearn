package com.tsx.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public class MyBatisPlusLambdaQueryWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void test01() {
        // 查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        // select * from user where name like '%a%' and age between 20 and 30 and email is not null;
        // QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // queryWrapper.like("name", "a")
        //         .between("age", 20, 30)
        //         .isNotNull("email");

        // LambdaQueryWrapper
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, "a")
                .between(User::getAge, 20, 30)
                .isNotNull(User::getEmail);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("users = " + users);
    }
}
