package cn.tsx.controller;

import cn.tsx.pojo.User;
import jakarta.ws.rs.Path;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ShengXuan
 * @create: 2023-09-25
 * @description:
 **/

@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping
    public List<User> page(@RequestParam(required = false, defaultValue = "1") int page,
                           @RequestParam(required = false, defaultValue = "10") int size) {
        System.out.println("page = " + page + ", size = " + size);
        return null;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        System.out.println("user = " + user);
        return user;
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable int id) {
        System.out.println("id = " + id);
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setAge(18);
        return user;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        System.out.println("user = " + user);
        return user;
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable int id) {
        System.out.println("id = " + id);
        return "ok";
    }

    @GetMapping("user/search")
    public List<User> search(@RequestParam(required = false, defaultValue = "1") int page,
                             @RequestParam(required = false, defaultValue = "10") int size,
                             String keywords) {
        System.out.println("page = " + page + ", size = " + size + ", keywords = " + keywords);
        return null;
    }
}
