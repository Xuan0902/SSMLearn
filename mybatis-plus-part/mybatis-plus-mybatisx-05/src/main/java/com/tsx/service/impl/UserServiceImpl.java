package com.tsx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tsx.mapper.UserMapper;
import com.tsx.pojo.User;
import com.tsx.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author Xuan
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-09-30 19:49:51
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




