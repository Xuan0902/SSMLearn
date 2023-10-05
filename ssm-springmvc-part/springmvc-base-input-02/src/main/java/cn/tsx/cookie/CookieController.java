package cn.tsx.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

/**
 * @author: ShengXuan
 * @create: 2023-09-24
 * @description: 接收cookie
 **/

@RestController
@RequestMapping("cookie")
public class CookieController {

    @RequestMapping("data")
    public String data(@CookieValue(value = "cookieValue") String value){
        System.out.println("value = " + value);
        return value;
    }

    @GetMapping("save")
    public String save(HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("cookieValue","root");
        httpServletResponse.addCookie(cookie);
        return "ok";
    }
}
