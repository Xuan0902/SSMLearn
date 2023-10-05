package cn.tsx.json;

import cn.tsx.pojo.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ShengXuan
 * @create: 2023-09-25
 * @description: JsonController
 **/

@RestController
@RequestMapping("json")
public class JsonController {
    @PostMapping("data")
    public User data(@RequestBody User user) {
        System.out.println("user = " + user);
        return user;
    }
}
