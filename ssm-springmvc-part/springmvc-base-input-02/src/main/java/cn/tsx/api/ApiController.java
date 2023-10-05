package cn.tsx.api;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ShengXuan
 * @create: 2023-09-24
 * @description: 原生对象获取
 **/

@RestController
public class ApiController {
    public void data(HttpServletResponse httpServletResponse,
                     HttpServletRequest httpServletRequest,
                     HttpSession httpSession){
            //使用原生对象就可以
        //ServletContext    [1.最大的配置文件 2.全局最大的共享域 3.核心api getRealPath]
        //方案1：request获取  session获取
        ServletContext context = httpServletRequest.getServletContext();
        ServletContext context1 = httpSession.getServletContext();
        //方案2：
    }
}
