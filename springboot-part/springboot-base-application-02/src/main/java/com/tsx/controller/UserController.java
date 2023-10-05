package com.tsx.controller;

import com.tsx.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private User user;

    @GetMapping("show")
    public User show() {
        return user;
    }
}
