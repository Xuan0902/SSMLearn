package com.tsx.service;

import com.tsx.common.dto.LoginUserDto;
import com.tsx.common.dto.RegisterUserDto;
import com.tsx.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tsx.utils.Result;

/**
 * @author Xuan
 * @description 针对表【news_user】的数据库操作Service
 * @createDate 2023-09-30 20:49:17
 */
public interface UserService extends IService<User> {

    /**
     * 登录业务
     *
     * @param loginUserDto
     * @return
     */
    Result login(LoginUserDto loginUserDto);

    /**
     * 根据token的userId查询用户信息
     *
     * @param token
     * @return
     */
    Result getUserInfo(String token);

    /**
     * 判定用户名是否重复
     *
     * @param username
     * @return
     */
    Result checkUserName(String username);

    /**
     * 注册用户
     *
     * @param registerUserDto
     * @return
     */
    Result regist(RegisterUserDto registerUserDto);
}
