package cn.tsx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

@Configuration
@ComponentScan("cn.tsx")
@EnableAspectJAutoProxy //开启支持aspectj的注解
public class JavaConfig {
}
