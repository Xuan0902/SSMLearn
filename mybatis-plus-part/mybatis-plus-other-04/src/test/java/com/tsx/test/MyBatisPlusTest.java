package com.tsx.test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tsx.mapper.UserMapper;
import com.tsx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-29
 * @description:
 **/

@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    public UserMapper userMapper;

    @Test
    void testPage() {
        Page<User> userPage = new Page<>(1, 3);
        userMapper.selectPage(userPage, null);
        // 结果page最后也会封装到结果中
        long current = userPage.getCurrent();   // 页码
        long size = userPage.getSize();     // 页容量
        List<User> records = userPage.getRecords(); // 数据
        long total = userPage.getTotal();   // 总数
        System.out.println("total = " + total);
        System.out.println("records = " + records);
        System.out.println("size = " + size);
        System.out.println("current = " + current);
    }

    @Test
    void testMyPage() {
        Page<User> userPage = new Page<>(1, 3);
        userMapper.queryByAge(userPage, 20);
        long current = userPage.getCurrent();   // 页码
        long size = userPage.getSize();     // 页容量
        List<User> records = userPage.getRecords(); // 数据
        long total = userPage.getTotal();   // 总数
        System.out.println("total = " + total);
        System.out.println("records = " + records);
        System.out.println("size = " + size);
        System.out.println("current = " + current);
    }
}
