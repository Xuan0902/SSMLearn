package cn.tsx.json;

import cn.tsx.pojo.Person;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ShengXuan
 * @create: 2023-09-24
 * @description: 接受json
 **/

@RestController
@RequestMapping("json")
public class JsonController {
    @PostMapping("data")
    @ResponseBody
    public String json(@RequestBody Person person) {
        System.out.println("person = " + person);
        // 在这里可以使用 person 对象来操作 JSON 数据中包含的属性
        return "success";
    }
}
