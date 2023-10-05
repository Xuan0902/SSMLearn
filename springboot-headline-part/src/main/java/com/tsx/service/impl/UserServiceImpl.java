package com.tsx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tsx.common.dto.LoginUserDto;
import com.tsx.common.dto.RegisterUserDto;
import com.tsx.pojo.User;
import com.tsx.service.UserService;
import com.tsx.mapper.UserMapper;
import com.tsx.utils.JwtHelper;
import com.tsx.utils.MD5Util;
import com.tsx.utils.Result;
import com.tsx.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Xuan
 * @description 针对表【news_user】的数据库操作Service实现
 * @createDate 2023-09-30 20:49:17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtHelper jwtHelper;

    /**
     * 登录业务
     * 1.根据账号，查询用户对象 -loginUser
     * 2.如果用户对象为null，查询失败，账号错误！501
     * 3.对比，密码，密码错误返回503
     * 4.根据用户id生成一个token，token->result 返回
     *
     * @param loginUserDto
     * @return
     */
    @Override
    public Result login(LoginUserDto loginUserDto) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, loginUserDto.username());
        User loginUser = userMapper.selectOne(lambdaQueryWrapper);
        if (loginUser == null) {
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        if (StringUtils.isNotBlank(loginUserDto.userPwd()) && MD5Util.encrypt(loginUserDto.userPwd()).equals(loginUser.getUserPwd())) {
            // 登录成功
            // 根据用户id生成token
            return Result.ok(Map.of("token",
                    jwtHelper.createToken(Long.valueOf(loginUser.getUid()))));
        }
        // 密码错误
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getUserInfo(String token) {
        // 判断有没有过期
        if (jwtHelper.isExpiration(token)) {
            return Result.build(null, ResultCodeEnum.NOT_LOGIN);
        }
        // 得到用户id
        Long userId = jwtHelper.getUserId(token);
        // 查询用户
        User user = userMapper.selectById(userId);
        // 要是用户不为空就返回
        user.setUserPwd(null);
        return Result.ok(Map.of("loginUser", user));
    }

    @Override
    public Result checkUserName(String username) {
        // 1.查整个user对象
        // LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // lambdaQueryWrapper.eq(User::getUsername, username);
        // User user = userMapper.selectOne(lambdaQueryWrapper);
        // if (user != null) {
        //     return Result.build(null, ResultCodeEnum.USERNAME_USED);
        // }
        // return Result.ok(null);
        // 2.查count
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, username);
        Long count = userMapper.selectCount(lambdaQueryWrapper);
        if (count != 0) {
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        return Result.ok(null);
    }

    @Override
    public Result regist(RegisterUserDto registerUserDto) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, registerUserDto.username());
        Long count = userMapper.selectCount(lambdaQueryWrapper);
        if (count > 0) {
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        User user = new User();
        user.setNickName(registerUserDto.nickName());
        user.setUsername(registerUserDto.username());
        user.setUserPwd(MD5Util.encrypt(registerUserDto.userPwd()));
        userMapper.insert(user);
        return Result.ok(null);
    }
}




