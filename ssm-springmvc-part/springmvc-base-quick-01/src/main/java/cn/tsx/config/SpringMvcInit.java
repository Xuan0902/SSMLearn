package cn.tsx.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author: ShengXuan
 * @create: 2023-09-24
 * @description: 可以被web项目加载，会初始化ioc容器，会设置dispatcherServlet的地址
 **/

public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //service mapper层的 ioc容器配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // 设置我们项目对应的配置类 springmvc controller
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
