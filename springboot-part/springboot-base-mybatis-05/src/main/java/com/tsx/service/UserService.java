package com.tsx.service;

import com.tsx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void delete() {
        int rows = userMapper.delete(3);
        System.out.println("rows = " + rows);
        int i = 1 / 0;
    }

}
