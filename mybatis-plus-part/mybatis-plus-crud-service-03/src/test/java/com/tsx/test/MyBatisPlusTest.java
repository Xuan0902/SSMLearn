package com.tsx.test;

import com.tsx.pojo.User;
import com.tsx.service.UserService;
import org.apache.ibatis.reflection.Jdk;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-29
 * @description:
 **/

@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private UserService userService;

    @Test
    void test_save() {
        User user = User.builder().name("jj").age(18).email("xxx@qq.com").build();
        User user1 = User.builder().name("jj11").age(88).email("jjj.com").build();
        List<User> list = Arrays.asList(user1, user);
        boolean b = userService.saveBatch(list);
        System.out.println("b = " + b);
    }

    @Test
    void test_saveOrUpdate() {
        // 如果id有值就是更新，没有值就是保存
        User user = User.builder().name("ggb").age(15).email("jjb.com").build();
        boolean b = userService.saveOrUpdate(user);
        System.out.println("b = " + b);
    }

    @Test
    void test_remove() {
        boolean b = userService.removeById(1707748801749250050L);
        System.out.println("b = " + b);
    }

    @Test
    void test_update() {
    }

    @Test
    void test_getOrList() {

    }
}
