package com.tsx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tsx.pojo.User;
import com.tsx.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author: ShengXuan
 * @create: 2023-09-29
 * @description:
 **/
@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void test_insert() {
        User.UserBuilder builder = User.builder();
        User user = builder.name("呵呵").age(88).email("xxx").build();
        // 插入方法
        int rows = userMapper.insert(user);
        System.out.println("rows = " + rows);
    }

    @Test
    void test_delete() {
        // 根据id删除
        int row = userMapper.deleteById(1707734991797792770L);
        System.out.println("row = " + row);
        // 根据age=20删除
        int rows = userMapper.deleteByMap(Map.of("age", 20));
        System.out.println("rows = " + rows);
    }

    @Test
    void test_update() {
        // user id=1 set age=30
        User user = User.builder().id(1L).age(30).build();
        // id必须有值，其次为什么要将age设置为integer类型 是因为要是用int的话就是默认为0就会使得有默认值是0
        int row = userMapper.updateById(user);
        System.out.println("row = " + row);
    }

    @Test
    void test_select() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 3L));
        System.out.println("users = " + users);
    }

}
