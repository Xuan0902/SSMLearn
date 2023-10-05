package com.tsx.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tsx.mapper.UserMapper;
import com.tsx.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author: ShengXuan
 * @create: 2023-09-29
 * @description:
 **/

@SpringBootTest
public class MyBatisPlusQueryWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void test_01() {
        // 查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        // select * from user where name like '%a%' and age between 20 and 30 and email is not null;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void test2() {
        // 按年龄降序查询用户，如果年龄相同则按id升序排列
        // select * from user order by age desc, id;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }

    @Test
    void test03() {
        // 删除email为空的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int delete = userMapper.delete(queryWrapper);
        System.out.println("delete = " + delete);
    }

    @Test
    void test04() {
        // 将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20)
                .like("name", "a")
                .or().isNull("email");
        User user = User.builder().age(88).name("updated").build();
        int update = userMapper.update(user, queryWrapper);
        System.out.println("update = " + update);
    }

    @Test
    void test05() {
        // 查询用户信息的username和age字段
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20);
        queryWrapper.select("name", "age");
        // List<User> users = userMapper.selectList(queryWrapper);
        List<Map<String, Object>> list = userMapper.selectMaps(queryWrapper);
        System.out.println("list = " + list);
        // System.out.println("users = " + users);
    }

    @Test
    void test06() {
        // 前端传入两个参数 age，name
        // name不为空，作为条件 = 查询
        // age>18,作为条件，查询等于age =
        String name = "xx";
        Integer age = 18;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // if (StringUtils.isNotBlank(name)) {
        //     queryWrapper.eq("name", name);
        // }
        // if (age != null && age > 18) {
        //     queryWrapper.eq("age", age);
        // }
        queryWrapper.eq(StringUtils.isNotBlank(name), "name", name)
                .eq(age != null && age > 18, "age", age);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println("users = " + users);
    }
}
