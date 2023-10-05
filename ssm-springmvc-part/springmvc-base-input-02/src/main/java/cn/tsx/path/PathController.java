package cn.tsx.path;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ShengXuan
 * @create: 2023-09-24
 * @description: 路径参数传参
 **/

@RestController
@RequestMapping("path")
public class PathController {
    @RequestMapping("{account}/{password}")
    public String path(@PathVariable String account, @PathVariable String password) {
        System.out.println("account = " + account + ", password = " + password);
        return "ok";
    }
}
