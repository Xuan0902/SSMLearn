package cn.tsx.param;

import cn.tsx.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-24
 * @description: 如何接收前端的param数据
 **/

@Controller
@RequestMapping("param")
public class ParamController {
    // 直接接收
    @RequestMapping("data")
    @ResponseBody
    public String data(String name, int age) {
        System.out.println("name = " + name + ", age = " + age);
        return "name = " + name + ", age = " + age;
    }

    // 注解接收
    @RequestMapping("data1")
    @ResponseBody
    public String data1(@RequestParam(value = "account") String username,
                        @RequestParam(required = false, defaultValue = "1") int page) {
        System.out.println("username = " + username + ", page = " + page);
        return "username = " + username + ", page = " + page;
    }

    // 特殊值
    // 一名多值
    @RequestMapping("data2")
    @ResponseBody
    // 集合接必须加RequestParam注解 数组不需要
    public String data2(@RequestParam List<Integer> key) {
        // System.out.println("key = " + Arrays.toString(key));
        // return "key = " + Arrays.toString(key);
        System.out.println("key = " + key);
        return "key" + key;
    }

    // 使用实体对象接值
    @RequestMapping("data3")
    @ResponseBody
    public String data3(User user) {
        System.out.println("user = " + user);
        return "ok";
    }
}
