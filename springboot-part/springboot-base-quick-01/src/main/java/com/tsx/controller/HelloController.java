package com.tsx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@RestController
@RequestMapping("hello")
public class HelloController {
    @Value("${tsx.name}")
    private String name;

    @GetMapping("boot")
    public String hello() {
        System.out.println("name = " + name);
        return "hello springboot3!!!";
    }
}
