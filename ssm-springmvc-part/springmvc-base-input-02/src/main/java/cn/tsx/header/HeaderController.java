package cn.tsx.header;

import jakarta.ws.rs.HeaderParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ShengXuan
 * @create: 2023-09-24
 * @description: 请求头接收
 **/

@RestController
@RequestMapping("header")
public class HeaderController {

    @RequestMapping("data")
    public String get(@RequestHeader("Host") String host){
        System.out.println("host = " + host);
        return host;
    }
}
