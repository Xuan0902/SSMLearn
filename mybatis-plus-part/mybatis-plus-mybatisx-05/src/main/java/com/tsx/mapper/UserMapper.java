package com.tsx.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Collection;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tsx.pojo.User;

/**
 * @author Xuan
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2023-09-30 19:49:51
 * @Entity com.tsx.pojo.User
 */
public interface UserMapper extends BaseMapper<User> {
    int insertBatch(@Param("userCollection") Collection<User> userCollection);
}




