package com.tsx.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.tsx.common.dto.LoginUserDto;
import com.tsx.common.dto.RegisterUserDto;
import com.tsx.service.UserService;
import com.tsx.utils.JwtHelper;
import com.tsx.utils.Result;
import com.tsx.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ShengXuan
 * @create: 2023-09-30
 * @description:
 **/

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("login")
    public Result login(@RequestBody LoginUserDto loginUserDto) {
        Result result = userService.login(loginUserDto);
        return result;
    }

    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token) {
        Result result = userService.getUserInfo(token);
        return result;
    }

    @PostMapping("checkUserName")
    public Result checkUserName(String username) {
        Result result = userService.checkUserName(username);
        return result;
    }

    @PostMapping("regist")
    public Result regist(@RequestBody RegisterUserDto registerUserDto) {
        Result result = userService.regist(registerUserDto);
        return result;
    }

    @GetMapping("checkLogin")
    public Result checkLogin(@RequestHeader String token) {
        if (StringUtils.isBlank(token) || jwtHelper.isExpiration(token)) {
            // 没有传或者过期 未登录
            return Result.build(null, ResultCodeEnum.NOT_LOGIN);
        }
        return Result.ok(null);
    }
}
