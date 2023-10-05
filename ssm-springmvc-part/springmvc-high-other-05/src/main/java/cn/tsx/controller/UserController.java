package cn.tsx.controller;

import cn.tsx.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: ShengXuan
 * @create: 2023-09-25
 * @description:
 **/

@RestController
@RequestMapping("user")
public class UserController {

    /**
     * @param user 要使校验注解生效 必须加@Validated注解
     */
    @PostMapping("register")
    public Object register(@Validated @RequestBody User user, BindingResult result) {
        System.out.println("user = " + user);
        if (result.hasErrors()) {
            return Map.of("code", "400", "msg", " 参数校验错误");
        }
        return user;
    }

    @GetMapping("data")
    public String data() {
        // String s = null;
        // s.toString();
        System.out.println("UserController.data");
        return "ok";
    }

    @GetMapping("data1")
    public String data1() {
        // int i = 1 / 0;
        System.out.println("UserController.data1");
        return "ok";
    }
}
