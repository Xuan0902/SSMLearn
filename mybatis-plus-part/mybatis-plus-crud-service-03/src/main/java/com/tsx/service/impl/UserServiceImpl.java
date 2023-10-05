package com.tsx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tsx.mapper.UserMapper;
import com.tsx.pojo.User;
import com.tsx.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: ShengXuan
 * @create: 2023-09-29
 * @description:
 **/

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
