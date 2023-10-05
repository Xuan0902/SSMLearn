package com.tsx.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
public class MybatisPlusUpdateWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void test01() {
        // 将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20)
                .like("name", "a")
                .or().isNull("email");
        // 这个只能改非空的属性值，为空就不改 不能实现set column = null这种
        User user = User.builder()
                .age(88)
                .name("updated").build();
        int update = userMapper.update(user, queryWrapper);
        System.out.println("update = " + update);
    }

    @Test
    void test02() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.gt("age", 20)
                .like("name", "a")
                .or().isNull("email")
                .set("name", null); // 使用set可以修改为null
        int update = userMapper.update(null, updateWrapper);
        System.out.println("update = " + update);
    }
}
