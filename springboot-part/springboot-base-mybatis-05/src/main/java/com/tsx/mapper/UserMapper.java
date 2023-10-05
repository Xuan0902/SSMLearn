package com.tsx.mapper;

import com.tsx.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@Mapper
public interface UserMapper {
    List<User> queryAll();

    @Delete("delete from user where id = #{id}")
    int delete(int id);
}
