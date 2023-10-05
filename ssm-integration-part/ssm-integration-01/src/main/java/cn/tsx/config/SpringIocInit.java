package cn.tsx.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author: ShengXuan
 * @create: 2023-09-27
 * @description: Spring环境的初始化类
 **/

public class SpringIocInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    // root的ioc容器的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ServiceJavaConfig.class, DataSourceJavaConfig.class, MapperJavaConfigNew.class};
    }

    // web的ioc容器的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcJavaConfig.class};
    }

    // dispatcherServlet的拦截路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
