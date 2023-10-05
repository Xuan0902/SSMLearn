package cn.tsx.config;

import cn.tsx.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author: ShengXuan
 * @create: 2023-09-25
 * @description: mvc组件的配置类
 **/

@Configuration
@EnableWebMvc
@ComponentScan("cn.tsx")
public class MvcConfig implements WebMvcConfigurer {
    // 指定视图解析器，指定前后缀
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // registry可以快速添加前后缀
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    // 开启静态资源查找
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    // 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置方案1：拦截全部请求
        // registry.addInterceptor(new MyInterceptor());

        // 配置方案2：指定地址拦截
        // 支持模糊地址 *任意一层  **任意多层字符串
        // registry.addInterceptor(new MyInterceptor())
        //         .addPathPatterns("/user/data");

        // 配置方案3：排除拦截   排除的地址应该在拦截地址的内部
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/data1");
    }
}
