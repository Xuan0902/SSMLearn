package com.tsx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tsx.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author: ShengXuan
 * @create: 2023-09-29
 * @description:
 **/

public interface UserMapper extends BaseMapper<User> {
    IPage<User> queryByAge(IPage<User> page, @Param("age") Integer age);
}
