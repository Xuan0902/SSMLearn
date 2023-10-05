package cn.tsx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author: ShengXuan
 * @create: 2023-09-26
 * @description: 控制层的配置类（controller，springmvc）
 **/

/**
 * 1.controller
 * 2.全局异常处理器
 * 3.handlerMapping handlerAdapter
 * 4.静态资源
 * 5.jsp 视图解析器
 * 6.json转换器
 * 7.拦截器
 */
@EnableWebMvc
@ComponentScan({"cn.tsx.controller", "cn.tsx.exceptionHandler"})
@Configuration
public class WebMvcJavaConfig implements WebMvcConfigurer {
    // 静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // jsp视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views", "jsp");
    }

    // 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
