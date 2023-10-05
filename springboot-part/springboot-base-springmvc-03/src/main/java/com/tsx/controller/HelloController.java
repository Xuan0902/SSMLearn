package com.tsx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description:
 **/

@RestController

public class HelloController {
    @GetMapping("hello")
    public String ref() {
        return "hello";
    }
}
