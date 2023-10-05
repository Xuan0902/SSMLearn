package cn.tsx.ioc_02;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

/*
Java的配置类，替代xml配置
    1.包扫描配置
    2.引入外部的配置文件
    3.引用第三方的Bean
 */

@ComponentScan("cn.tsx.ioc_02")
@Configuration
@Import({ConfigurationA.class, ConfigurationB.class})
public class SpringConfiguration {

}
