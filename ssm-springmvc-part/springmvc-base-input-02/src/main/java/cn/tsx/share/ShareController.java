package cn.tsx.share;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ShengXuan
 * @create: 2023-09-24
 * @description: 演示共享域对象获取
 **/

@RestController
@RequestMapping("share")
public class ShareController {
    // 原生api
    public void data(HttpServletRequest request){

    }
}
