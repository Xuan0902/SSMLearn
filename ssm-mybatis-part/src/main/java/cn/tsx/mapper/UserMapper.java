package cn.tsx.mapper;

import cn.tsx.pojo.User;

/**
* @author Xuan
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-09-24 14:47:28
* @Entity cn.tsx.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
