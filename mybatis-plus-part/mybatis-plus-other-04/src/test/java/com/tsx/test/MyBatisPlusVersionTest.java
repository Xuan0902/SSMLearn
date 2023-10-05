package com.tsx.test;

import com.tsx.mapper.UserMapper;
import com.tsx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: ShengXuan
 * @create: 2023-09-30
 * @description:
 **/

@SpringBootTest
public class MyBatisPlusVersionTest {
    @Autowired
    private UserMapper userMapper;

    // 演示乐观锁生效场景
    @Test
    public void testQuick7() {
        // 步骤1: 先查询,在更新 获取version数据
        // 同时查询两条,但是version唯一,最后更新的失败
        User user = userMapper.selectById(5);
        User user1 = userMapper.selectById(5);

        user.setAge(20);
        user1.setAge(30);

        userMapper.updateById(user);
        // 乐观锁生效,失败!
        userMapper.updateById(user1);
    }
}
