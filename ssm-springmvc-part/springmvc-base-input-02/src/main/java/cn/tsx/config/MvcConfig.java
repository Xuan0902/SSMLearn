package cn.tsx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author: ShengXuan
 * @create: 2023-09-24
 * @description: springmvc配置类 controller，handlerMapping，handlerAdapter 放入ioc容器
 **/

@Configuration
@ComponentScan({"cn.tsx"})
@EnableWebMvc
public class MvcConfig {
    @Bean
    public RequestMappingHandlerMapping handlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter handlerAdapter() {
        return new RequestMappingHandlerAdapter();
    }
    // @Bean
    // public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
    //     return new MappingJackson2HttpMessageConverter();
    // }

}


