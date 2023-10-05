package cn.tsx.jsp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: ShengXuan
 * @create: 2023-09-25
 * @description: jsp的controller
 **/

@Controller
@RequestMapping("jsp")
public class JspController {

    /**
     * TODO：快速查找试图
     *      1.方法的返回值是字符串类型
     *      2.不能添加@ResponseBody,直接返回给字符串给浏览器，不找视图，不走试图解析器
     *      3.返回值 对应中间的视图名称即可
     */
    @GetMapping("index")
    public String index(HttpServletRequest request) {
        request.setAttribute("data", "hello jsp!!! ");
        System.out.println("JspController.index");
        return "index";
    }

    // 转发 加forward
    @GetMapping("forward")
    public String forward() {
        System.out.println("JspController.forward");
        return "forward:/jsp/index";
    }

    // 重定向 加redirect
    @GetMapping("redirect")
    public String redirect() {
        System.out.println("JspController.redirect");
        return "redirect:/jsp/index";
    }
}
