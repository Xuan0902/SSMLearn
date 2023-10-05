package cn.tsx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: ShengXuan
 * @create: 2023-09-25
 * @description: mvc组件配置
 **/

@EnableWebMvc
@ComponentScan("cn.tsx")
@Configuration
public class MvcConfig implements WebMvcConfigurer {
}
