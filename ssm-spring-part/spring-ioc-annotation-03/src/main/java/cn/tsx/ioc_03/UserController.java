package cn.tsx.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

@Controller
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")   //指定注入哪个组件
        //必须配合Autowired注解进行使用
    private UserService userService;


    @Resource(name = "userServiceImpl")
    private UserService userService1;

    public void show() {
        System.out.println(userService.show());
    }
}
