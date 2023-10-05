package cn.tsx.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

@Component
public class JavaBean {
    @Value("18")
    private String name;

    /*
    @Value 默认值语法 ${属性名:默认值}
     */
    @Value("${jdbc.username:admin}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
