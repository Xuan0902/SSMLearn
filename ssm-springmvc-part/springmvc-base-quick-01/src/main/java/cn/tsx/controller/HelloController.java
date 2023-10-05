package cn.tsx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: ShengXuan
 * @create: 2023-09-24
 * @description:
 **/

@Controller
public class HelloController {
    @RequestMapping("springmvc/hello")
    @ResponseBody
    public String hello() {
        System.out.println("hello");
        return "hello world";
    }
}
