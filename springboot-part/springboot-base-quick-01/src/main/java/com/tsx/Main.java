package com.tsx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description: 启动类
 **/

// 1.配置类
// 2.自动加载配置 @EnableAutoConfiguration 自动加载其他的配置类
@SpringBootApplication  // 启动类
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args); // 自动创建ioc容器，启动tomcat服务器软件
    }
}
